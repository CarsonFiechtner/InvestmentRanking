import java.util.Scanner;

/**
 * @author Carson Fiechtner
 * A DefensiveInvestor wants to receive a respectable ROI
 * while keeping their work load relatively low
 * 
 * Because of this, a DefensiveInvestor generally prefer
 * stocks with low volatility, high dividends, low risk, etc
 * 
 * NOTE: While consideration was placed into what a typical
 * defensive investor values, deductions are calculated using
 * arbitrary values
 */
public class DefensiveInvestor extends BasicInvestor{

	/**
	 * Default constructor for a defensive investor
	 */
	public DefensiveInvestor(){}

	/**
	 * Allows the user to input info about their stock
	 */
	public void getStockInfo(Scanner input){
		System.out.println("What is the stock's market value? ($B)");
		setMarketValue(input.nextDouble());
		System.out.println("What is the stock's annual earnings growth? (%)");
		setAnnEarningsGrowth(input.nextDouble());
		System.out.println("What is the stock's Price-to-Earnings Ratio?");
		setPE_Ratio(input.nextDouble());
		System.out.println("What is the stock's Price-to-Book Ratio?");
		setPB_Ratio(input.nextDouble());
		System.out.println("What percentage of this stock is owned by institutions?");
		setInstPercent(input.nextDouble());
		System.out.println("What is the stock's Debt-to-Equity Ratio?");
		setDE_Ratio(input.nextDouble());
		System.out.println("Has your stock maintained consistent earnings for at least 10 years? (Y/N)");
		setConsistentEarnings(booleanConvert(input.next()));
		System.out.println("If applicable, has your stock maintained consistent dividend payments? (Y/N)");
		setConsistentDividends(booleanConvert(input.next()));
	}

	/**
	 * Calculates score based on the value of all instance variables
	 */
	public void calculateScore(){
		if(marketValue < 2)
			deductions += 5*(2-marketValue);
		if(annualEarningsGrowth < 4)
			deductions += 3*(4 - annualEarningsGrowth);
		if(peRatio > 15)
			deductions += 1.5 * (peRatio - 15);
		if(pbRatio > 1.5)
			deductions += (pbRatio - 1.5);
		if(institutionPercent > 60)
			deductions += 0.5*(institutionPercent - 60);
		if(debtEquityRatio > 2)
			deductions += 5*(debtEquityRatio-2);
		if(!consistentEarnings)
			deductions += 8;
		if(!consistentDividends)
			deductions += 8;
		score = score - deductions;
	}

	/**
	 * Returns the stock's current score
	 * @return The stock's current score
	 */
	public double getScore(){
		return score;
	}

	/**
	 * Resets the values of score and deductions to 100 and 0, respectively.
	 */
	public void reset(){
		score = 100;
		deductions = 0;
	}
	public static void main(String[] args){
		boolean newStock = true;
		DefensiveInvestor stock;
		Scanner check = new Scanner(System.in);
		while(newStock){
			stock = new DefensiveInvestor();
			stock.getStockInfo(check);
			stock.calculateScore();
			System.out.println("Your stock's score is: " + stock.getScore() + "/100");
			System.out.println("Would you like to test another stock? (Y/N)");
			if(check.hasNext())
				newStock = stock.booleanConvert(check.next());
		}
		check.close();
		System.out.println("Thanks for using this stock ranker!");
	}
}



