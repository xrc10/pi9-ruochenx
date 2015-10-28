
/* First created by JCasGen Sun Oct 04 16:51:34 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Mon Oct 26 23:48:33 EDT 2015
 * @generated */
public class Measurement_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Measurement_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Measurement_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Measurement(addr, Measurement_Type.this);
  			   Measurement_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Measurement(addr, Measurement_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Measurement.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.Measurement");
 
  /** @generated */
  final Feature casFeat_precisionAt1;
  /** @generated */
  final int     casFeatCode_precisionAt1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getPrecisionAt1(int addr) {
        if (featOkTst && casFeat_precisionAt1 == null)
      jcas.throwFeatMissing("precisionAt1", "type.Measurement");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precisionAt1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrecisionAt1(int addr, double v) {
        if (featOkTst && casFeat_precisionAt1 == null)
      jcas.throwFeatMissing("precisionAt1", "type.Measurement");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precisionAt1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_precisionAt5;
  /** @generated */
  final int     casFeatCode_precisionAt5;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getPrecisionAt5(int addr) {
        if (featOkTst && casFeat_precisionAt5 == null)
      jcas.throwFeatMissing("precisionAt5", "type.Measurement");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precisionAt5);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrecisionAt5(int addr, double v) {
        if (featOkTst && casFeat_precisionAt5 == null)
      jcas.throwFeatMissing("precisionAt5", "type.Measurement");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precisionAt5, v);}
    
  
 
  /** @generated */
  final Feature casFeat_reciprocalRank;
  /** @generated */
  final int     casFeatCode_reciprocalRank;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getReciprocalRank(int addr) {
        if (featOkTst && casFeat_reciprocalRank == null)
      jcas.throwFeatMissing("reciprocalRank", "type.Measurement");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_reciprocalRank);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setReciprocalRank(int addr, double v) {
        if (featOkTst && casFeat_reciprocalRank == null)
      jcas.throwFeatMissing("reciprocalRank", "type.Measurement");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_reciprocalRank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_averagePrecision;
  /** @generated */
  final int     casFeatCode_averagePrecision;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getAveragePrecision(int addr) {
        if (featOkTst && casFeat_averagePrecision == null)
      jcas.throwFeatMissing("averagePrecision", "type.Measurement");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_averagePrecision);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAveragePrecision(int addr, double v) {
        if (featOkTst && casFeat_averagePrecision == null)
      jcas.throwFeatMissing("averagePrecision", "type.Measurement");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_averagePrecision, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Measurement_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_precisionAt1 = jcas.getRequiredFeatureDE(casType, "precisionAt1", "uima.cas.Double", featOkTst);
    casFeatCode_precisionAt1  = (null == casFeat_precisionAt1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precisionAt1).getCode();

 
    casFeat_precisionAt5 = jcas.getRequiredFeatureDE(casType, "precisionAt5", "uima.cas.Double", featOkTst);
    casFeatCode_precisionAt5  = (null == casFeat_precisionAt5) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precisionAt5).getCode();

 
    casFeat_reciprocalRank = jcas.getRequiredFeatureDE(casType, "reciprocalRank", "uima.cas.Double", featOkTst);
    casFeatCode_reciprocalRank  = (null == casFeat_reciprocalRank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_reciprocalRank).getCode();

 
    casFeat_averagePrecision = jcas.getRequiredFeatureDE(casType, "averagePrecision", "uima.cas.Double", featOkTst);
    casFeatCode_averagePrecision  = (null == casFeat_averagePrecision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_averagePrecision).getCode();

  }
}



    