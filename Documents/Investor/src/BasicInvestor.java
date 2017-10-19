
/**
 * @author Carson Fiechtner
 * Description:
 * An abstract class that contains the basic instance variables and methods
 * for ranking stocks
 */
public abstract class BasicInvestor {
	protected double score = 100;
	protected double deductions = 0;
	
	//Instance variables for score calculation
	protected double marketValue = 0, annualEarningsGrowth = 0, peRatio = 0, 
			pbRatio = 0, institutionPercent = 0, debtEquityRatio = 0, psRatio = 0;
	protected boolean consistentEarnings = false, consistentDividends = false;
	/**
	 * Sets the value of the marketValue variable
	 * @param mv The new value of marketValue
	 */
	protected void setMarketValue(double mv) {
		marketValue = mv;
	}
	
	/**
	 * Sets the value of the annualEarningsGrowth variable
	 * @param aeg The new value of annualEarningsGrowth
	 */
	protected void setAnnEarningsGrowth(double aeg){
		annualEarningsGrowth = aeg;
	}
	
	/**
	 * Sets the value of the peRatio variable
	 * @param pe The new value of peRatio
	 */
	protected void setPE_Ratio(double pe){
		peRatio = pe;
	}
	
	/**
	 * Sets the value of the pbRatio variable
	 * @param pb The new value of pbRatio
	 */
	protected void setPB_Ratio(double pb){
		pbRatio = pb;
	}
	
	/**
	 * Sets the value of the institutionPercent variable
	 * @param ip The new value of institutionPercent
	 */
	protected void setInstPercent(double ip){
		institutionPercent = ip;
	}
	
	/**
	 * Sets the value of the debtEquityRatio variable
	 * @param de The new value of debtEquityRatio
	 */
	protected void setDE_Ratio(double de){
		debtEquityRatio = de;
	}
	
	/**
	 * Sets the value of the psRatio variable
	 * @param al The new value of assetLiabilityRatio
	 */
	protected void setPS_Ratio(double ps){
		psRatio = ps;
	}
	
	/**
	 * Sets the value of the consistentEarnings variable
	 * @param ce The new value of consistentEarnings
	 */
	protected void setConsistentEarnings(boolean ce){
		consistentEarnings = ce;
	}
	
	/**
	 * Sets the value of the consistentDividends variable
	 * @param cd The new value of consistentDividends
	 */
	protected void setConsistentDividends(boolean cd){
		consistentDividends = cd;
	}
	
	/**
	 * Converts a string into a boolean
	 * @param phrase The string that will be converted into a boolean
	 * @return True if string is some form of yes, false otherwise
	 */
	public boolean booleanConvert(String phrase){
		switch(phrase){
		case "Y":
		case "y":
		case "Yes":
		case "yes":
			return true;
		default:
			return false;
		}
	}
}
