
/* First created by JCasGen Mon Sep 28 17:16:05 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

/**
 * Stores a token annotation. Updated by JCasGen Mon Sep 28 17:16:05 EDT 2015 XML source:
 * /home/ruochenx/git/pi4-ruochenx/pi4-ruochenx/src/main/resources/descriptors/typeSystem.xml
 * 
 * @generated
 */
public class Token extends ComponentAnnotation implements Comparable {
  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);

  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int type = typeIndexID;

  /**
   * @generated
   * @return index of the type
   */
  @Override
  public int getTypeIndexID() {return typeIndexID;}
 
  /**
   * Never called. Disable default constructor
   * 
   * @generated
   */
  protected Token() {/* intentionally empty block */}
    
  /**
   * Internal - constructor used by generator
   * 
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param type
   *          the type of this Feature Structure
   */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /**
   * @generated
   * @param jcas
   *          JCas to which this Feature Structure belongs
   */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /**
   * @generated
   * @param jcas
   *          JCas to which this Feature Structure belongs
   * @param begin
   *          offset to the begin spot in the SofA
   * @param end
   *          offset to the end spot in the SofA
   */
  public Token(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc --> Write your own initialization here <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {
    /* default - does nothing empty block */}

  @Override
  public int compareTo(Object compareAnnot) {
    // TODO Auto-generated method stub
    int compared = ((Token) compareAnnot).getBegin();
    if (compared > this.getBegin()) {
      return -1;
    } else if (compared < this.getBegin()) {
      return 1;
    } else {
      return 0;
    }
  }

}
