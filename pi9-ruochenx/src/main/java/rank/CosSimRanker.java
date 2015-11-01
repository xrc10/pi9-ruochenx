package rank;

import java.util.HashMap;
import java.util.Iterator;

import type.Passage;
import type.Question;

public class CosSimRanker extends AbstractRanker {

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
    HashMap<String, Integer> quesitonCounter = tokenCounter(questionTokenContainer);

    TokenContainer passageTokenContainer = new TokenContainer();
    passageTokenContainer.tokenize(passage.getText());
    HashMap<String, Integer> passageCounter = tokenCounter(passageTokenContainer);

    return computeCosSimScore(quesitonCounter, passageCounter);
  }

  HashMap<String, Integer> tokenCounter(TokenContainer tokens) {
    HashMap<String, Integer> counter = new HashMap<String, Integer>();
    for (Iterator iter = tokens.getIterator(); iter.hasNext();) {
      String token = (String) iter.next();
      if (counter.containsKey(token)) {
        int oldValue = counter.get(token);
        counter.put(token, oldValue + 1);
      } else {
        counter.put(token, 1);
      }
    }
    return counter;
  }

  double computeCosSimScore(HashMap<String, Integer> counter1, HashMap<String, Integer> counter2) {
    double l2norm1 = 0;
    double l2norm2 = 0;
    double prdct = 0;
    for (String key : counter1.keySet()) {
      l2norm1 += Math.pow(counter1.get(key),2);
    }
    for (String key : counter2.keySet()) {
      l2norm2 += Math.pow(counter2.get(key),2);
    }
    for (String key : counter1.keySet()) {
      if (counter2.containsKey(key)) {
        prdct += counter1.get(key)*counter2.get(key);
      }
    }
//    System.out.println(prdct/(Math.sqrt(l2norm1)*Math.sqrt(l2norm2)));
    return prdct/(Math.sqrt(l2norm1)*Math.sqrt(l2norm2));
  }
}
