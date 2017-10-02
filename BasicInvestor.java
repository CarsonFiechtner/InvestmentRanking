
/**
 * @author Carson Fiechtner
 * Description:
 * An interface that contains the basic instance variables and methods
 * for ranking stocks
 */
public interface BasicInvestor {
	
	/**
	 * Sets the value of the marketValue variable
	 * @param mv The new value of marketValue
	 */
	public void setMarketValue(double mv);
	
	/**
	 * Sets the value of the annualEarningsGrowth variable
	 * @param aeg The new value of annualEarningsGrowth
	 */
	public void setAnnEarningsGrowth(double aeg);
	
	/**
	 * Sets the value of the p_eRatio variable
	 * @param pe The new value of p_eRatio
	 */
	public void setPE_Ratio(double pe);
	
	/**
	 * Sets the value of the p_bRatio variable
	 * @param pb The new value of p_bRatio
	 */
	public void setPB_Ratio(double pb);
	
	/**
	 * Sets the value of the institutionPercent variable
	 * @param ip The new value of institutionPercent
	 */
	public void setInstPercent(double ip);
	
	/**
	 * Sets the value of the assetLiabilityRatio variable
	 * @param al The new value of assetLiabilityRatio
	 */
	public void setAL_Ratio(double al);
	
	/**
	 * Sets the value of the consistentEarnings variable
	 * @param ce The new value of consistentEarnings
	 */
	public void setConsistentEarnings(boolean ce);
	
	/**
	 * Sets the value of the consistentDividends variable
	 * @param cd The new value of consistentDividends
	 */
	public void setConsistentDividends(boolean cd);
}
