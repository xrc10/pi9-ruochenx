package rank;

public abstract class Evaluator {
  protected IRanker ranker;
  
  protected Evaluator(IRanker ranker){
    this.ranker = ranker;
 }
  
  public abstract void evaluate();
}
