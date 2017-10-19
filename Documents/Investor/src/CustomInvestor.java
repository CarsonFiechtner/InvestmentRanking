import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Carson Fiechtner
 * A CustomInvestor is customized to what the user values
 * 
 * Because of this, one CustomInvestor could rank a stock very
 * highly, while another could rank that same stock poorly.
 * 
 */
public class CustomInvestor extends BasicInvestor{

	private double [] opinions = new double[9];
	private String [] names = {"Market Value:", "Annual Earnings Growth:", "Price-to-Earnings Ratio:",
	                             "Price-to-Book:", "Institution Percentage:", "Debt-to-Equity Ratio:", 
	                             "Price-to-Sales Ratio:", "Consistent Earnings:", "Consistent Dividends:"};
	
	/**
	 * Default constructor for a aggressive investor
	 */
	public CustomInvestor(){}

	public void setOpinions(Scanner input){
		System.out.println("Please rank the following stock characteristics on a 1-10 scale:");
		for(int i = 0; i < opinions.length; i++){
			System.out.println(names[i]);
			opinions[i] = input.nextDouble();
		}
	}
	
	/**
	 * Allows the user to input info about their stock
	 */
	public void getStockInfo(Scanner input){
		System.out.println("Please enter the following data on your stock:");
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
		System.out.println("Has your stock maintained consistent earnings for at least 10 years? (Y/N)");
		setConsistentEarnings(booleanConvert(input.next()));
		System.out.println("If applicable, has your stock maintained consistent dividend payments? (Y/N)");
		System.out.println("If not applicable, please enter \"Y\" ");
		setConsistentDividends(booleanConvert(input.next()));
	}

	/**
	 * Calculates score based on the value of all instance variables
	 */
	public void calculateScore(){
		if(marketValue < 2)
			deductions += (opinions[0]/2)*(2-marketValue);
		if(annualEarningsGrowth < 4)
			deductions += (opinions[1]/2)*(4 - annualEarningsGrowth);
		if(peRatio > 15)
			deductions += (opinions[2]/5)*(peRatio - 15);
		if(pbRatio > 1.5)
			deductions += (opinions[3]/5)*(pbRatio - 1.5);
		if(institutionPercent > 60)
			deductions += (opinions[4]/3.33)*(institutionPercent - 60);
		if(debtEquityRatio > 2)
			deductions += (opinions[5]/2)*(debtEquityRatio-2);
		if(psRatio > 4)
			deductions += (opinions[6]/2)*(psRatio - 4);
		if(!consistentEarnings)
			deductions += opinions[7];
		if(!consistentDividends)
			deductions += opinions[8];
		score = score - deductions;
	}

	/**
	 * Returns the stock's current score
	 * @return The stock's current score
	 */
	public double getScore(){
		DecimalFormat df = new DecimalFormat("#.##");      
		score = Double.valueOf(df.format(score));
		return score;
	}

	public static void main(String[] args){
		boolean newStock = true;
		CustomInvestor stock;
		Scanner check = new Scanner(System.in);
		while(newStock){
			stock = new CustomInvestor();
			stock.setOpinions(check);
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



