package rank;

import java.util.ArrayList;
import java.util.List;

import type.Passage;
import type.Question;

public class QAEvaluator extends Evaluator {

  private Question question;

  private List<Passage> passages;

  public double precisionAt1 = 0, precisionAt5 = 0, reciprocalRank = 0, averagePrecision = 0;

  public QAEvaluator(IRanker ranker, Question question, List<Passage> passages) {
    super(ranker);
    this.question = question;
    this.passages = passages;
  }

  @Override
  public void evaluate() {
    // TODO Auto-generated method stub
    List<Passage> rankedPassages = super.ranker.rank(this.question, this.passages);

    precisionAt1 = precisionAtN(rankedPassages, 1);
    precisionAt5 = precisionAtN(rankedPassages, 5);
    
    double sumOfPrecision = 0;
    int numberOfHits = 0;
    for (int i = 0; i < rankedPassages.size(); i++) {
      Passage passageAnnot = rankedPassages.get(i);
      if (passageAnnot.getLabel()) {
        if (numberOfHits == 0) {
          reciprocalRank = 1.0/(i+1);
        }
        sumOfPrecision += precisionAtN(rankedPassages, i + 1);
        numberOfHits++;
      }
    }
    if (numberOfHits != 0) {
      averagePrecision = sumOfPrecision / numberOfHits;
    }
  }

  public double precisionAtN(List<Passage> passageArray, int n) {
    double numberOfHits = 0;
    for (int i = 0; i < n; i++) {
      if (passageArray.get(i).getLabel()) {
        numberOfHits++;
      }
    }
    return numberOfHits / n;
  }
}
