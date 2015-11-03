import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import rank.CompositeRanker;
import rank.IRanker;
import rank.NgramRanker;
import rank.QAEvaluator;
import rank.CosSimRanker;
import type.Measurement;
import type.Passage;
import type.Question;
import weka.classifiers.Classifier;
import weka.classifiers.functions.Logistic;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 * This CAS Consumer generates the report file with the method metrics
 */
public class PassageRankingWriter extends CasConsumer_ImplBase {
  final String PARAM_OUTPUTDIR = "OutputDir";

  final String PARAM_NUMFOLDS = "NumFolds";

  final String OUTPUT_FILENAME = "RankMeasurements.csv";

  File mOutputDir;

  int numFolds;

  IRanker ngramRanker, cosSimRanker;

  CompositeRanker compositeRanker;

  @Override
  public void initialize() throws ResourceInitializationException {
    String mOutputDirStr = (String) getConfigParameterValue(PARAM_OUTPUTDIR);
    if (getConfigParameterValue(PARAM_NUMFOLDS) != null) {
      numFolds = (int) getConfigParameterValue(PARAM_NUMFOLDS);
    }
    if (mOutputDirStr != null) {
      mOutputDir = new File(mOutputDirStr);
      if (!mOutputDir.exists()) {
        mOutputDir.mkdirs();
      }
    }

    // Initialize rankers
    compositeRanker = new CompositeRanker();
    ngramRanker = new NgramRanker();
    cosSimRanker = new CosSimRanker();
    compositeRanker.addRanker(ngramRanker);
    compositeRanker.addRanker(cosSimRanker);
  }

  @Override
  public void processCas(CAS arg0) throws ResourceProcessException {
    System.out.println(">> Passage Ranking Writer Processing");
    // Import the CAS as a aJCas
    JCas aJCas = null;
    File outputFile = null;
    PrintWriter writer = null;
    try {
      aJCas = arg0.getJCas();
      try {
        outputFile = new File(Paths.get(mOutputDir.getAbsolutePath(), OUTPUT_FILENAME).toString());
        outputFile.getParentFile().mkdirs();
        writer = new PrintWriter(outputFile);
      } catch (FileNotFoundException e) {
        System.out.printf("Output file could not be written: %s\n",
                Paths.get(mOutputDir.getAbsolutePath(), OUTPUT_FILENAME).toString());
        return;
      }

      writer.println("question_id,p_at_1,p_at_5,rr,ap");

      // Retrieve all the questions.
      List<Question> allQuestions = UimaUtils.getAnnotations(aJCas, Question.class);

      // Train a model to get the optimized weights.
      List<Double> weights = train(allQuestions, compositeRanker);

      // Use the learned weights for rank aggregation (composition).
      compositeRanker.setWeights(weights);

      // TODO: Here one needs to sort the questions in ascending order of their question ID
      Collections.sort(allQuestions);
      double pAt1 = 0;
      double pAt5 = 0;
      double mrr = 0;
      double map = 0;
      for (Question question : allQuestions) {
        List<Passage> passages = UimaUtils.convertFSArraytToList(question.getPassages(),
                Passage.class);

        // You could compare the composite ranker with individual rankers her.
        // List<Passage> ngramRankedPassages = ngramRanker.rank(question, passages);
        // List<Passage> otherRankedPassages = otherRanker.rank(question, passages);

        // TODO: Compute the measurement for this question.
        QAEvaluator evaluator = new QAEvaluator(compositeRanker, question, passages);

        evaluator.evaluate();

        pAt1 += evaluator.precisionAt1;
        pAt5 += evaluator.precisionAt5;
        mrr += evaluator.reciprocalRank;
        map += evaluator.averagePrecision;

        writer.printf("%s,%.3f,%.3f,%.3f,%.3f\n", question.getId(), evaluator.precisionAt1,
                evaluator.precisionAt5, evaluator.reciprocalRank, evaluator.averagePrecision);
      }
      System.out.printf("pAt1:%f\tpAt5:%f\tmrr:%f\tmap:%f\n", pAt1 / allQuestions.size(),
              pAt5 / allQuestions.size(), mrr / allQuestions.size(),
              map / allQuestions.size());
    } catch (CASException e) {
      try {
        throw new CollectionException(e);
      } catch (CollectionException e1) {
        e1.printStackTrace();
      }
    } finally {
      if (writer != null)
        writer.close();
    }
  }

  /**
   * Trains a logistic regression model on the given question data through cross validation.
   * Optimizes the weights on individual rankers with respect to P@1.
   * 
   * @param allQuestions
   * @return the optimized weights
   */
  public List<Double> train(List<Question> questions, CompositeRanker ranker) {
    // TODO: Complete the implementation of this method.
    System.out.println(String.format(
            ">> Training a logistic regression model with %d-fold cross validation", numFolds));

    // ### Implementation guidelines ###
    // 1. Split the data into k folds for cross validation.
    // 2. For each fold, do the following:
    // 2-1. Get the training and validation datasets for this fold.
    // 2-2. Train the model on the training dataset while tuning hyperparameters.
    // 2-3. Compute P@1 of the trained composite model on the validation dataset.
    // 3. Compute the average of P@1 over the validation datasets.
    // 4. Get the best hyperparameters that give you the best average of P@1.
    // 5. Train the model on the entire dataset with the best hyperparameters you get in step 4.
    // 6. Return the learned weights you get in step 5.

    // weights[0] is for the n-gram ranker, and weights[1] is for the other ranker.
    List<Double> weights = new ArrayList<Double>();

    // 1. Split the data into k folds for cross validation.
    // folds[0] is the 1st fold, and folds[1] is the 2nd one, etc.
    List<List<Question>> folds = splitFolds(questions, numFolds);

    // construct hyperparameter space
    List<Double> ridges = new ArrayList<Double>();
    List<Double> precisonAt1List = new ArrayList<Double>();

    for (int i = -3; i < 3; i++) {
      ridges.add(Math.pow(10, i));
      precisonAt1List.add(0.0);
    }

    for (int i = 0; i < folds.size(); i++) {
      // 2. For each fold, do the following:
      System.out.format("Cross Validating on %d th fold\n", i + 1);

      // 2-1. Get the training and validation data sets for this fold.
      // Instances validationData = convertQuestionsToInstances(folds.get(i), ranker);
      Instances trainingData = convertQuestionsToInstances(getRemainFolds(folds, i), ranker);

      // Reinitialize the logistic regression model by creating a new instance.
      Logistic classifier = new Logistic();

      // 2-2. Train the model on the training dataset while tuning hyperparameters.
      for (int j = 0; j < ridges.size(); j++) {
        System.out.format("Tuning ridge of %f\n", ridges.get(j));
        // set hyperparameter ridge
        classifier.setRidge(ridges.get(j));

        // training
        try {
          classifier.buildClassifier(trainingData);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        // 2-3. Compute P@1 of the trained composite model on the validation dataset.
        // extract model coefficients as weights
        List<Double> tmpWeights = new ArrayList<Double>();
        double[][] coef = classifier.coefficients();
        for (int k = 0; k < ranker.rankers.size(); k++) {
          tmpWeights.add(coef[k][0]);
        }
        System.out.format("Learned weight is %s\n", tmpWeights.toString());
        // rank using the tmpWeights
        compositeRanker.setWeights(tmpWeights);
        // evaluate
        double meanPrecisionAt1 = 0;
        for (Question question : getRemainFolds(folds, i)) {
          List<Passage> passages = UimaUtils.convertFSArraytToList(question.getPassages(),
                  Passage.class);
          QAEvaluator evaluator = new QAEvaluator(compositeRanker, question, passages);
          evaluator.evaluate();
          meanPrecisionAt1 += evaluator.precisionAt1;
        }
        meanPrecisionAt1 = meanPrecisionAt1/getRemainFolds(folds, i).size();
        precisonAt1List.set(j, precisonAt1List.get(j) + meanPrecisionAt1);
      }
    }
    // 3. Compute the average of P@1 over the validation datasets.
    for (int i = 0; i < precisonAt1List.size(); i++) {
      precisonAt1List.set(i, precisonAt1List.get(i) / folds.size());
      System.out.format("P@1 for ridge %f is %f\n", ridges.get(i), precisonAt1List.get(i));
    }
    // 4. Get the best hyperparameters that give you the best average of P@1.
    double bestPrecisionAt1 = Collections.max(precisonAt1List);
    double bestRidge = ridges.get(precisonAt1List.indexOf(bestPrecisionAt1));
    System.out.format("best P@1 is %f, best ridge is %f\n", bestPrecisionAt1, bestRidge);

    // 5. Train the model on the entire dataset with the best hyperparameters you get in step 4.
    Instances trainingData = convertQuestionsToInstances(getRemainFolds(folds, -1), ranker);
    Logistic classifier = new Logistic();
    classifier.setRidge(bestRidge);
    try {
      classifier.buildClassifier(trainingData);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // 6. Return the learned weights you get in step 5.
    double[][] coef = classifier.coefficients();
    for (int k = 0; k < ranker.rankers.size(); k++) {
      weights.add(coef[k][0]);
    }
    System.out.format("Final learned weight is %s\n", weights.toString());
    return weights;
  }

  /**
   * Converts the given questions to Weka instances.
   * 
   * @param questions
   * @return Weka instances
   */
  public Instances convertQuestionsToInstances(List<Question> questions, CompositeRanker ranker) {
    // TODO: Complete the implementation of this method.

    // construct attributes
    ArrayList<Attribute> attribs = new ArrayList<Attribute>();
    for (int i = 0; i < ranker.rankers.size(); i++) {
      Attribute attrib = new Attribute(Integer.toString(i), i);
      attribs.add(attrib);
    }
    // set class attribute
    List classNominalValue = new ArrayList(2);
    classNominalValue.add("False");
    classNominalValue.add("True");

    attribs.add(new Attribute("class", classNominalValue));

    Instances dataset = new Instances("dataset", attribs, 0);

    for (Question question : questions) {
      List<Passage> passages = UimaUtils.convertFSArraytToList(question.getPassages(),
              Passage.class);
      for (Passage passage : passages) {
        Instance inst = new DenseInstance(ranker.rankers.size() + 1);
        inst.setDataset(dataset);
        for (int i = 0; i < ranker.rankers.size(); i++) {
          double score = ranker.rankers.get(i).score(question, passage);
          inst.setValue(i, score);
        }
        if (passage.getLabel()) {
          inst.setValue(ranker.rankers.size(), "True");
        } else {
          inst.setValue(ranker.rankers.size(), "False");
        }
        dataset.add(inst);
      }
    }
    dataset.setClassIndex(ranker.rankers.size());
    return dataset;
  }

  /**
   * get folds of questions list.
   * 
   * @param List<Question>
   *          data
   * @param int
   *          k
   * @return List<List<Question>>
   */
  public List<List<Question>> splitFolds(List<Question> data, int k) {
    // construct list of list object
    List<List<Question>> folds = new ArrayList<List<Question>>();
    int foldSize = (int) (data.size() / k);
    // construct each list object
    for (int i = 0; i < k; i++) {
      List<Question> fold = new ArrayList<Question>();
      folds.add(fold);
    }
    // assign each data to a split of fold
    for (int i = 0; i < data.size(); i++) {
      int foldIndex = (int) (i / foldSize);
      // deal with last split, which maybe contain more than foldSize data
      foldIndex = Math.min(foldIndex, k - 1);
      folds.get(foldIndex).add(data.get(i));
    }
    return folds;
  }

  /**
   * get remaining folds of List<List<Question>> folds and training index i.
   * 
   * @param List<List<Question>>
   *          folds
   * @param int
   *          i
   * @return List<Question>
   */
  @SuppressWarnings("null")
  public List<Question> getRemainFolds(List<List<Question>> folds, int i) {
    List<Question> remainFolds = new ArrayList<Question>();
    for (int j = 0; j < folds.size(); j++) {
      if (j != i) {
        remainFolds.addAll(folds.get(j));
      }
    }
    return remainFolds;
  }

}
