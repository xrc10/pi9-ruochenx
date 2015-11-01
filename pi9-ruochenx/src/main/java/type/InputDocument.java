

/* First created by JCasGen Sun Oct 04 16:19:56 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


import org.apache.uima.jcas.cas.FSList;


/** Stores all the questions and its associated answer candidates.
 * Updated by JCasGen Thu Oct 08 22:31:01 EDT 2015
 * XML source: /home/ruochenx/git/pi6-ruochenx/pi6-ruochenx/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class InputDocument extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(InputDocument.class);
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
  protected InputDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public InputDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public InputDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public InputDocument(JCas jcas, int begin, int end) {
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
  //* Feature: passages

  /** getter for passages - gets All the passages found in the input file.
   * @generated
   * @return value of the feature 
   */
  public FSArray getPassages() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.InputDocument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages)));}
    
  /** setter for passages - sets All the passages found in the input file. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassages(FSArray v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for passages - gets an indexed value - All the passages found in the input file.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Passage getPassages(int i) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages), i);
    return (Passage)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages), i)));}

  /** indexed setter for passages - sets an indexed value - All the passages found in the input file.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setPassages(int i, Passage v) { 
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_passages), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: questions

  /** getter for questions - gets All the questions found in the input file.
   * @generated
   * @return value of the feature 
   */
  public FSArray getQuestions() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.InputDocument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions)));}
    
  /** setter for questions - sets All the questions found in the input file. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestions(FSArray v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for questions - gets an indexed value - All the questions found in the input file.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Question getQuestions(int i) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions), i);
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions), i)));}

  /** indexed setter for questions - sets an indexed value - All the questions found in the input file.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setQuestions(int i, Question v) { 
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_questions), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    