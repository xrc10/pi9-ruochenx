package rank;

import java.util.List;

import type.Passage;
import type.Question;

public class QAEvaluator extends Evaluator {

  private Question question;

  private List<Passage> passages;

  public int tp = 0, fp = 0, fn = 0;
  public double precision = 0, recall = 0, f1 = 0;

  public QAEvaluator(IRanker ranker, Question question, List<Passage> passages) {
    super(ranker);
    this.question = question;
    this.passages = passages;
  }

  @Override
  public void evaluate() {
    // TODO Auto-generated method stub
    List<Passage> rankedPassages = super.ranker.rank(this.question, this.passages);
    tp = 0;
    fn = 0;
    fp = 0;
    int threshold = 5;
    for (int i = 0; i < rankedPassages.size(); i++) {
      Passage passageAnnot = rankedPassages.get(i);
      if (i < threshold) {
        if (passageAnnot.getLabel()) {
          tp++;
        } else {
          fn++;
        }
      } else {
        if (passageAnnot.getLabel()) {
          fn++;
        }
      }
    }
    if (tp != 0) {
      precision = (double) tp / (tp + fp);
      recall = (double) tp / (tp + fn);
      f1 = 2 * precision * recall / (precision + recall);
    } else if (fn == 0){
      recall = 1;
    }
  }

}
