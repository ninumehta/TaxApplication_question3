package TaxPersonMain;

import java.math.BigDecimal;

/**
 * Class to calculate the total amount after taxes from the cost and tax rate
 * 
 * @author Ninu Mehta
 * 
 */

public class Item {
	static final double NECESSITY_ITEM_TAX_RATE = 0.01;
	static final double LUXURY_ITEM_TAX_RATE = 0.09;
	private boolean isLuxury;
	private double cost;

	public Item(boolean isLuxury, double cost) {
		super();
		this.isLuxury = isLuxury;
		this.cost = cost;
	}

	public boolean isLuxury() {
		return isLuxury;
	}

	public void setLuxury(boolean isLuxury) {
		this.isLuxury = isLuxury;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Methos to calculate Cost with Tax included
	 * 
	 * @return
	 */
	public double calculateCostPlusTax() {
		double netCost = 0.0;
		if (isLuxury) {
			netCost = rounded(cost * (1 + LUXURY_ITEM_TAX_RATE));
		} else {
			netCost = rounded(cost * (1 + NECESSITY_ITEM_TAX_RATE));
		}
		return netCost;
	}

	/**
	 * Method to round input to 2 decimal places(representing cents)
	 * 
	 * @param input
	 * @return
	 */
	public double rounded(double input) {
		// Round to 2 decimal places
		BigDecimal amount = new BigDecimal(input);
		return amount.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();

	}
}
