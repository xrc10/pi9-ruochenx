

/* First created by JCasGen Wed Oct 07 16:14:08 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** Store the result of evaluation.
 * Updated by JCasGen Thu Oct 08 22:31:01 EDT 2015
 * XML source: /home/ruochenx/git/pi6-ruochenx/pi6-ruochenx/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class Evaluation extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Evaluation.class);
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
  protected Evaluation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Evaluation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Evaluation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Evaluation(JCas jcas, int begin, int end) {
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
  //* Feature: questions

  /** getter for questions - gets The questions whose measurement is evaluated.
   * @generated
   * @return value of the feature 
   */
  public FSArray getQuestions() {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.Evaluation");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions)));}
    
  /** setter for questions - sets The questions whose measurement is evaluated. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestions(FSArray v) {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.Evaluation");
    jcasType.ll_cas.ll_setRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for questions - gets an indexed value - The questions whose measurement is evaluated.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Question getQuestions(int i) {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.Evaluation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions), i);
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions), i)));}

  /** indexed setter for questions - sets an indexed value - The questions whose measurement is evaluated.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setQuestions(int i, Question v) { 
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_questions == null)
      jcasType.jcas.throwFeatMissing("questions", "type.Evaluation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Evaluation_Type)jcasType).casFeatCode_questions), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    