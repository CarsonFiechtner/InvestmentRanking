/**
 * @author Carson Fiechtner
 * A DefensiveInvestor wants to receive a respectable ROI
 * while keeping their work load relatively low
 * 
 * NOTE: Method comments can be found in the BasicInvestor Interface
 */
public class DefensiveInvestor implements BasicInvestor {
	
	//Score begins at 100, decreases with each sub-par attribute
	public double score = 100;
	
	//Instance variables for score calculation
	private double marketValue = 0, annualEarningsGrowth = 0, peRatio = 0, 
			pbRatio = 0, institutionPercent = 0, assetLiabilityRatio = 0;
	private boolean consistentEarnings = false, consistentDividends = false;

	/**
	 * Default constructor for a defensive investor
	 */
	public DefensiveInvestor(){}
	/**
	 * Calculates score based on the value of all instance variables
	 */
	public void setScore(){
		double deductions = 0;
		if(marketValue < 2)
			deductions += 5*(2-marketValue);
		if(annualEarningsGrowth < 4)
			deductions += 5*(4 - annualEarningsGrowth);
		if(peRatio > 15)
			deductions += (peRatio - 15);
		if(pbRatio > 1.5)
			deductions += 4*(pbRatio - 1.5);
		if(institutionPercent > 60)
			deductions += 0.5*(institutionPercent - 60);
		if(assetLiabilityRatio < 2)
			deductions += 5*(2 - assetLiabilityRatio);
		if(!consistentEarnings)
			deductions += 5;
		if(!consistentDividends)
			deductions += 5;
		score = score - deductions;
	}

	@Override
	public void setMarketValue(double mv) {
		marketValue = mv;
	}

	@Override
	public void setAnnEarningsGrowth(double aeg) {
		annualEarningsGrowth = aeg;
	}

	@Override
	public void setPE_Ratio(double pe) {
		peRatio = pe;
	}

	@Override
	public void setPB_Ratio(double pb) {
		pbRatio = pb;
	}

	@Override
	public void setInstPercent(double ip) {
		institutionPercent = ip;
	}

	@Override
	public void setAL_Ratio(double al) {
		assetLiabilityRatio = al;
	}

	@Override
	public void setConsistentEarnings(boolean ce) {
		consistentEarnings = ce;
	}

	@Override
	public void setConsistentDividends(boolean cd) {
		consistentDividends = cd;
	}

	public static void main(String[] args){
		DefensiveInvestor d1 = new DefensiveInvestor();
		d1.setMarketValue(1.5);
		d1.setAnnEarningsGrowth(5);
		d1.setPE_Ratio(12);
		d1.setPB_Ratio(3.5);
		d1.setInstPercent(71);
		d1.setAL_Ratio(0.4);
		d1.setConsistentEarnings(true);
		d1.setConsistentDividends(false);
		System.out.println(d1.score);
		d1.setScore();
		System.out.println(d1.score);
	}
}


