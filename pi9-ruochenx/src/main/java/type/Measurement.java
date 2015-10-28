

/* First created by JCasGen Sun Oct 04 16:51:34 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Mon Oct 26 23:48:33 EDT 2015
 * XML source: /home/junaraki/git/f15-11-791/template-projects/pi9/pi9-andrewid/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class Measurement extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Measurement.class);
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
  protected Measurement() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Measurement(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Measurement(JCas jcas) {
    super(jcas);
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
  //* Feature: precisionAt1

  /** getter for precisionAt1 - gets Precision@1
   * @generated
   * @return value of the feature 
   */
  public double getPrecisionAt1() {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_precisionAt1 == null)
      jcasType.jcas.throwFeatMissing("precisionAt1", "type.Measurement");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_precisionAt1);}
    
  /** setter for precisionAt1 - sets Precision@1 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrecisionAt1(double v) {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_precisionAt1 == null)
      jcasType.jcas.throwFeatMissing("precisionAt1", "type.Measurement");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_precisionAt1, v);}    
   
    
  //*--------------*
  //* Feature: precisionAt5

  /** getter for precisionAt5 - gets Precision@5
   * @generated
   * @return value of the feature 
   */
  public double getPrecisionAt5() {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_precisionAt5 == null)
      jcasType.jcas.throwFeatMissing("precisionAt5", "type.Measurement");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_precisionAt5);}
    
  /** setter for precisionAt5 - sets Precision@5 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrecisionAt5(double v) {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_precisionAt5 == null)
      jcasType.jcas.throwFeatMissing("precisionAt5", "type.Measurement");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_precisionAt5, v);}    
   
    
  //*--------------*
  //* Feature: reciprocalRank

  /** getter for reciprocalRank - gets Reciprocal rank
   * @generated
   * @return value of the feature 
   */
  public double getReciprocalRank() {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_reciprocalRank == null)
      jcasType.jcas.throwFeatMissing("reciprocalRank", "type.Measurement");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_reciprocalRank);}
    
  /** setter for reciprocalRank - sets Reciprocal rank 
   * @generated
   * @param v value to set into the feature 
   */
  public void setReciprocalRank(double v) {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_reciprocalRank == null)
      jcasType.jcas.throwFeatMissing("reciprocalRank", "type.Measurement");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_reciprocalRank, v);}    
   
    
  //*--------------*
  //* Feature: averagePrecision

  /** getter for averagePrecision - gets Average precision
   * @generated
   * @return value of the feature 
   */
  public double getAveragePrecision() {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_averagePrecision == null)
      jcasType.jcas.throwFeatMissing("averagePrecision", "type.Measurement");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_averagePrecision);}
    
  /** setter for averagePrecision - sets Average precision 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAveragePrecision(double v) {
    if (Measurement_Type.featOkTst && ((Measurement_Type)jcasType).casFeat_averagePrecision == null)
      jcasType.jcas.throwFeatMissing("averagePrecision", "type.Measurement");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Measurement_Type)jcasType).casFeatCode_averagePrecision, v);}    
  }

    