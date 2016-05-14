package taxTest;
import static org.testng.AssertJUnit.assertEquals;
import org.junit.*;
import TaxPersonMain.*;

/**
 * Unit Tests for Tax Person Application
 * @author Ninu Mehta
 *
 */
public class TaxUnitTest {

@Test
	public void testTaxCalForNecessityItemWithNoDecimal(){
		Item item = new Item ( false, 100);
		Double amount = item.calculateCostPlusTax();
		System.out.println("amount: " + amount);
		assertEquals(amount,101.0);
	}

@Test
public void testTaxCalForNecessityItemWithOneDecimal(){
	Item item = new Item ( false, 200.2);
	Double amount = item.calculateCostPlusTax();
	System.out.println("amount: " + amount);
	assertEquals(amount,202.2);
}

@Test
public void testTaxCalForNecessityItemWithTwoDecimal(){
	Item item = new Item ( false, 400.44);
	Double amount = item.calculateCostPlusTax();
	System.out.println("amount: " + amount);
	assertEquals(amount,404.44);
}

@Test
public void testTaxCalForLuxuryItem(){
	Item item = new Item ( true, 100.22);
	Double amount = item.calculateCostPlusTax();
	System.out.println("amount: " + amount);
	assertEquals(amount,109.24);
	}
	
@Test
public void testTaxCalForZeroCost(){
	Item item = new Item ( true, 0);
	Double amount = item.calculateCostPlusTax();
	System.out.println("amount: " + amount);
	assertEquals(amount,0.0);
}   

@Test
public void testValidateCostForIntegerInput(){
	System.out.println("testValidateCostForIntegerInput: " + TaxMainPage.validateCost("100"));
	assertEquals(TaxMainPage.validateCost("100"), true);
}
@Test
public void testValidateCostForDoubleInput(){
	System.out.println("testValidateCostForDoubleInput: " + TaxMainPage.validateCost("100.45"));
	assertEquals(TaxMainPage.validateCost("100.45"), true);
}
@Test
public void testValidateCostForNegativeInput(){
	System.out.println("testValidateCostForNegativeInput: " + TaxMainPage.validateCost("-100.45"));
	assertEquals(TaxMainPage.validateCost("-100.45"), false);
}
@Test
public void testValidateCostForInvalidInput(){
	System.out.println("testValidateCostForInvalidInput: " + TaxMainPage.validateCost("abc"));
	assertEquals(TaxMainPage.validateCost("abc"), false);
}

@Test
public void testValidateItemTypeForYES(){
	assertEquals(TaxMainPage.validateItemType("YES"),true );
}
@Test
public void testValidateItemTypeForNO(){
	assertEquals(TaxMainPage.validateItemType("n"),true );
}
@Test
public void testValidateItemTypeForBadData(){
	assertEquals(TaxMainPage.validateItemType("ERT"),false );
}

}
