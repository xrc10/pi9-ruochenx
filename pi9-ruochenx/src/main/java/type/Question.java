

/* First created by JCasGen Sun Oct 04 16:19:56 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


import org.apache.uima.jcas.cas.FSList;


/** Stores the information about a question.
 * Updated by JCasGen Thu Oct 08 22:31:02 EDT 2015
 * XML source: /home/ruochenx/git/pi6-ruochenx/pi6-ruochenx/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class Question extends ComponentAnnotation implements Comparable {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Question(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets The identifier for the question.
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets The identifier for the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets The text of the question.
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets The text of the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentence, v);}    
   
    
  //*--------------*
  //* Feature: passages

  /** getter for passages - gets Passages associated with this question.
   * @generated
   * @return value of the feature 
   */
  public FSArray getPassages() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages)));}
    
  /** setter for passages - sets Passages associated with this question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassages(FSArray v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for passages - gets an indexed value - Passages associated with this question.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Passage getPassages(int i) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages), i);
    return (Passage)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages), i)));}

  /** indexed setter for passages - sets an indexed value - Passages associated with this question.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setPassages(int i, Passage v) { 
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: measurement

  /** getter for measurement - gets This stores all the measurements related to the question.
   * @generated
   * @return value of the feature 
   */
  public Measurement getMeasurement() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_measurement == null)
      jcasType.jcas.throwFeatMissing("measurement", "type.Question");
    return (Measurement)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_measurement)));}
    
  /** setter for measurement - sets This stores all the measurements related to the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMeasurement(Measurement v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_measurement == null)
      jcasType.jcas.throwFeatMissing("measurement", "type.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_measurement, jcasType.ll_cas.ll_getFSRef(v));}    
  
  @Override
  public int compareTo(Object compareAnnot) {
    // TODO Auto-generated method stub
    int compareId = Integer.parseInt(((Question) compareAnnot).getId());
    if (compareId > Integer.parseInt(this.getId())) {
      return -1;
    } else if (compareId < Integer.parseInt(this.getId())) {
      return 1;
    } else {
      return 0;
    }
  }  

  }

    