package rank;

import java.util.ArrayList;

import org.apache.uima.jcas.JCas;

import type.Ngram;
import type.Passage;
import type.Question;

public class NgramRanker extends AbstractRanker {

  /**
   * Returns a score of the given passage associated with the given question.
   * 
   * @param question
   * @param passage
   * @return a score of the passage
   */
  @Override
  public Double score(Question question, Passage passage) {
    // TODO Complete the implementation of this method.
    TokenContainer questionTokenContainer = new TokenContainer();
    questionTokenContainer.tokenize(question.getSentence());
    TokenContainer passageTokenContainer = new TokenContainer();
    passageTokenContainer.tokenize(passage.getText());
    return computeNGramScore(2, questionTokenContainer.tokens, passageTokenContainer.tokens);
  }

  double computeNGramScore(int n, ArrayList<String> tokens1, ArrayList<String> tokens2) {
    double hits = 0.0;
    for (int i=0; i< tokens1.size()-n+1; i++) {
      for (int j=0; j<tokens2.size()-n+1; j++) {
        boolean match = true;
        for (int k=0; k<n; k++) {
          if (!(tokens1.get(i+k).equals(tokens2.get(j+k)))) {
            match = false;
            break;
          }
        }
        if (match) {
          hits += 1;
          break;
        }
      }
    }
//    System.out.println(hits);
//    System.out.format("%f, %d, %f\n", hits, tokens1.size()-n+1, hits/(tokens1.size()-n+1));
    return hits/(tokens1.size()-n+1);
  }
}
