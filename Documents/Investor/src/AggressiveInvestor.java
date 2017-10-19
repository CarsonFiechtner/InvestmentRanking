import java.util.Scanner;

/**
 * @author Carson Fiechtner
 * An AggressiveInvestor is prepared to invest more time and
 * effort in exchange for a greater potential reward
 * 
 * Because of this, an AggressiveInvestor is less dismayed by
 * sub-par fundamentals, and focus more on growth.
 * 
 * NOTE: While consideration was placed into what a typical
 * aggressive investor values, deductions are calculated using
 * arbitrary values
 */
public class AggressiveInvestor extends BasicInvestor{

	/**
	 * Default constructor for a aggressive investor
	 */
	public AggressiveInvestor(){}

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
		System.out.println("What is your stock's Price-to-Sales Ratio?");
		setPS_Ratio(input.nextDouble());
	}

	/**
	 * Calculates score based on the value of all instance variables
	 */
	public void calculateScore(){
		if(marketValue < 2)
			deductions += 2*(2-marketValue);
		if(annualEarningsGrowth < 4)
			deductions += 5*(4 - annualEarningsGrowth);
		if(peRatio > 15)
			deductions += (peRatio - 15);
		if(pbRatio > 1.5)
			deductions += (pbRatio - 1.5);
		if(institutionPercent > 60)
			deductions += 2*(institutionPercent - 60);
		if(debtEquityRatio > 2)
			deductions += 2*(debtEquityRatio-2);
		if(psRatio > 4)
			deductions += 2.5*(psRatio - 4);
		score = score - deductions;
	}

	/**
	 * Returns the stock's current score
	 * @return The stock's current score
	 */
	public double getScore(){
		return score;
	}

	public static void main(String[] args){
		boolean newStock = true;
		AggressiveInvestor stock;
		Scanner check = new Scanner(System.in);
		while(newStock){
			stock = new AggressiveInvestor();
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



