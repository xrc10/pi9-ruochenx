import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import rank.OtherRanker;
import type.Measurement;
import type.Passage;
import type.Question;
import weka.classifiers.Classifier;
import weka.classifiers.functions.Logistic;
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

  IRanker ngramRanker, otherRanker;

  CompositeRanker compositeRanker;

  @Override
  public void initialize() throws ResourceInitializationException {
    String mOutputDirStr = (String) getConfigParameterValue(PARAM_OUTPUTDIR);
    if (mOutputDirStr != null) {
      mOutputDir = new File(mOutputDirStr);
      if (!mOutputDir.exists()) {
        mOutputDir.mkdirs();
      }
    }
    numFolds = (int) getConfigParameterValue(PARAM_NUMFOLDS);

    // Initialize rankers
    compositeRanker = new CompositeRanker();
    ngramRanker = new NgramRanker();
    otherRanker = new OtherRanker();
    compositeRanker.addRanker(ngramRanker);
    compositeRanker.addRanker(otherRanker);
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
      List<Double> weights = train(allQuestions);

      // Use the learned weights for rank aggregation (composition).
      compositeRanker.setWeights(weights);

      // TODO: Here one needs to sort the questions in ascending order of their question ID
      for (Question question : allQuestions) {
        List<Passage> passages = UimaUtils.convertFSListToList(question.getPassages(),
                Passage.class);

        // You could compare the composite ranker with individual rankers her.
        // List<Passage> ngramRankedPassages = ngramRanker.rank(question, passages);
        // List<Passage> otherRankedPassages = otherRanker.rank(question, passages);
        List<Passage> compositeRankedPassages = compositeRanker.rank(question, passages);

        // TODO: Compute the measurement for this question.
        Measurement m = question.getMeasurement();

        writer.printf("%s,%.3f,%.3f,%.3f,%.3f\n", question.getId(), m.getPrecisionAt1(),
                m.getPrecisionAt5(), m.getReciprocalRank(), m.getAveragePrecision());
      }
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
  public List<Double> train(List<Question> questions) {
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
    List<List<Question>> folds = new ArrayList<List<Question>>();

    for (int i = 0; i < folds.size(); i++) {
      // 2. For each fold, do the following:

      // 2-1. Get the training and validation datasets for this fold.
      Instances validationData = convertQuestionsToInstances(folds.get(i));
      Instances trainingData = convertQuestionsToInstances(null);

      // Reinitialize the logistic regression model by creating a new instance.
      Classifier classifier = new Logistic();

    }

    return weights;
  }

  /**
   * Converts the given questions to Weka instances.
   * 
   * @param questions
   * @return Weka instances
   */
  public Instances convertQuestionsToInstances(List<Question> questions) {
    // TODO: Complete the implementation of this method.

    return null;
  }

}
