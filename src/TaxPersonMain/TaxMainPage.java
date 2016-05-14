package TaxPersonMain;

/**
 * Main Class that starts the application.
 * It prompts user for amount and itemType, validates it and prints amount with Tax
 * @Author: Ninu Mehta
 */
import java.util.*;
import java.math.*;

public class TaxMainPage {
	
	public static void main(String[] args){
		String inputCost = null;
		boolean validInput = false;
		String itemType = "";
		boolean validItemType = false;
		boolean isLuxuryItem = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Tax Calcualting Sytem");
		//Prompt user for amount till a valid amount is entered
		do{
			System.out.println("Print Enter Cost of the Item in dollars: ");
			if(scan.hasNext()){
				inputCost = scan.next();
				if(validateCost(inputCost)){
					validInput = true;
				}
			}
		}	while(!validInput);
		
		//Prompt User if it is luxury item or not
		
		do{
			System.out.println("Please say Y or Yes if it is luxury item:");
			if(scan.hasNext()){
				itemType = scan.next();
			//	if (itemType.trim().equalsIgnoreCase("yes")|| itemType.trim().equalsIgnoreCase("no") ||itemType.trim().equalsIgnoreCase("y")|| itemType.trim().equalsIgnoreCase("n") ){
				if(validateItemType(itemType)){
					validItemType = true;
					System.out.println("Valid Item Type");
					if (itemType.trim().equalsIgnoreCase("yes")|| itemType.trim().equalsIgnoreCase("y")){
						isLuxuryItem = true;
						System.out.println("Luxury Item Type");
					}
				}
				 
			}
		
		}while(!validItemType);
		
		//Create an Item Object and Find the Cost With Tax
		Double cost = Double.parseDouble(inputCost);
		Item item = new Item(isLuxuryItem,cost);
		System.out.println("Cost with taxes : " + item.calculateCostPlusTax());
		
		
	}
	
	/**
	 * Method to find if cost is a valid amount
	 * @param cost 
	 * @return true if cost is valid, else false
	 */
	public static boolean validateCost(String cost) {
		Double amount = 0.0;
		try{
		amount = Double.parseDouble(cost);
		if (amount < 0)throw new Exception();
		return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Method to find if itemType is a valid entry
	 * @param itemType
	 * @return true is a valid itemType is entered, else false
	 */
	public static boolean validateItemType(String itemType){
		if (itemType.trim().equalsIgnoreCase("yes")|| itemType.trim().equalsIgnoreCase("no") 
				||itemType.trim().equalsIgnoreCase("y")|| itemType.trim().equalsIgnoreCase("n") ){
			return true;
		}else
			return false;
	}
	
	
}
