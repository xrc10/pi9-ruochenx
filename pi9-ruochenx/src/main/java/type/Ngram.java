
/* First created by JCasGen Mon Sep 28 17:16:05 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;

/**
 * Stores the information about an n-gram. Updated by JCasGen Mon Sep 28 17:16:05 EDT 2015 XML
 * source:
 * /home/ruochenx/git/pi4-ruochenx/pi4-ruochenx/src/main/resources/descriptors/typeSystem.xml
 * 
 * @generated
 */
public class Ngram extends ComponentAnnotation implements Comparable {
  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = JCasRegistry.register(Ngram.class);

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
  protected Ngram() {/* intentionally empty block */}
    
  /**
   * Internal - constructor used by generator
   * 
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param type
   *          the type of this Feature Structure
   */
  public Ngram(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /**
   * @generated
   * @param jcas
   *          JCas to which this Feature Structure belongs
   */
  public Ngram(JCas jcas) {
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
  public Ngram(JCas jcas, int begin, int end) {
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

  // *--------------*
  // * Feature: n

  /**
   * getter for n - gets The number of tokens in this n-gram.
   * 
   * @generated
   * @return value of the feature
   */
  public int getN() {
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_n == null)
      jcasType.jcas.throwFeatMissing("n", "type.Ngram");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Ngram_Type)jcasType).casFeatCode_n);}
    
  /**
   * setter for n - sets The number of tokens in this n-gram.
   * 
   * @generated
   * @param v
   *          value to set into the feature
   */
  public void setN(int v) {
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_n == null)
      jcasType.jcas.throwFeatMissing("n", "type.Ngram");
    jcasType.ll_cas.ll_setIntValue(addr, ((Ngram_Type)jcasType).casFeatCode_n, v);}    
   
    
  // *--------------*
  // * Feature: tokens

  /**
   * getter for tokens - gets Tokens contained in this n-gram.
   * 
   * @generated
   * @return value of the feature
   */
  public FSArray getTokens() {
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "type.Ngram");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens)));}
    
  /**
   * setter for tokens - sets Tokens contained in this n-gram.
   * 
   * @generated
   * @param v
   *          value to set into the feature
   */
  public void setTokens(FSArray v) {
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "type.Ngram");
    jcasType.ll_cas.ll_setRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /**
   * indexed getter for tokens - gets an indexed value - Tokens contained in this n-gram.
   * 
   * @generated
   * @param i
   *          index in the array to get
   * @return value of the element at index i
   */
  public Token getTokens(int i) {
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "type.Ngram");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens), i)));}

  /**
   * indexed setter for tokens - sets an indexed value - Tokens contained in this n-gram.
   * 
   * @generated
   * @param i
   *          index in the array to set
   * @param v
   *          value to set into the array
   */
  public void setTokens(int i, Token v) { 
    if (Ngram_Type.featOkTst && ((Ngram_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "type.Ngram");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Ngram_Type)jcasType).casFeatCode_tokens), i, jcasType.ll_cas.ll_getFSRef(v));}
    @Override
  public int compareTo(Object compareAnnot) {
    // TODO Auto-generated method stub
    int compared = ((Ngram) compareAnnot).getBegin();
    if (compared > this.getBegin()) {
      return -1;
    } else if (compared < this.getBegin()) {
      return 1;
    } else {
      return 0;
    }
  }
}
