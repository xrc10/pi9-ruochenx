import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import type.InputDocument;
import type.Passage;
import type.Question;

public class PassageAnnotator extends JCasAnnotator_ImplBase {
  private Pattern mPassagePattern = Pattern.compile("(\\d{4}) ([A-Z0-9]+\\.\\d{4}) (-?[12]) (.*)");

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    System.out.println(">> Passage Annotator Processing");
    // construct InputDocument instance to contain question and passages
    InputDocument inputDocumentAnnot = new InputDocument(aJCas);
    inputDocumentAnnot.setComponentId(this.getClass().getName());
    inputDocumentAnnot.setScore(1.0f);
    inputDocumentAnnot.setBegin(0);
    // get document text from the CAS
    String docText = aJCas.getDocumentText();
    inputDocumentAnnot.setEnd(docText.length());
    // search for all the questions in the text
    ArrayList<Passage> passageArray = new ArrayList<Passage>();
    Matcher matcher = mPassagePattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // found one - create annotation
      Passage annotation = new Passage(aJCas);
      annotation.setBegin(matcher.start(4));
      annotation.setEnd(matcher.end(4));
      annotation.setQuestionId(matcher.group(1));
      annotation.setSourceDocId(matcher.group(2));
      annotation.setLabel(!(matcher.group(3).compareTo("-1") == 0));
      annotation.setText(matcher.group(4));
      annotation.addToIndexes();
      pos = matcher.end();
      passageArray.add(annotation);
      // System.out.printf("Added P: %s-%s - %s\n", matcher.group(1), matcher.group(2),
      // matcher.group(4));
    }
    // save passages to InputDocument instance
    FSArray allPassages = new FSArray(aJCas, passageArray.size());
    for (int i = 0; i < passageArray.size(); i++) {
      allPassages.set(i, passageArray.get(i));
    }
    inputDocumentAnnot.setPassages(allPassages);
    // put passages into their corresponding question and save questions to inputDocument
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator questionIterator = questionIndex.iterator();
    FSArray allQuestions = new FSArray(aJCas, questionIndex.size());
    int i = 0;
    while (questionIterator.hasNext()) {
      Question questionAnnot = (Question) questionIterator.next();
      ArrayList<Passage> passagesForThisQuestion = new ArrayList<Passage>();
      for (int j = 0; j < passageArray.size(); j++) {
        if (passageArray.get(j).getQuestionId().equals(questionAnnot.getId())) {
          passagesForThisQuestion.add(passageArray.get(j));
        }
      }
      FSArray passages = new FSArray(aJCas, passagesForThisQuestion.size());
      for (int k = 0; k < passagesForThisQuestion.size(); k++) {
        passages.set(k, passagesForThisQuestion.get(k));
      }
      questionAnnot.setPassages(passages);
      allQuestions.set(i, questionAnnot);
      i++;
    }
    inputDocumentAnnot.setQuestions(allQuestions);
    inputDocumentAnnot.addToIndexes();
  }

}
