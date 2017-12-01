
package com.emids.quotations.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.enums.HabitRulesExecutor;


/**
 * @author Shekhar Arya
 * 
 * Unit test to test Habits of applicant
 *
 */
public class HabitsTest {
	
	private long quote;
	private String smoking;
	private String alcohol;
	private String drugs;
	private String dailyExercise;

	@Before
	public void setUp()  {
		 quote = QuotationGeneratorConstants.BASE_PREMIUM;
		 smoking = "yes";
		 alcohol = "yes";
		 drugs = "yes";
		 dailyExercise = "yes";
	}

	@Test
	public void testSmoking() {
		
		quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.SMOKING, convertBoolean(smoking)).execute();
		Assert.assertEquals(quote,  5150L);
	}
	
	@Test
	public void testAlcohol() {
		
		quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.ALCOHOL, convertBoolean(alcohol)).execute();
		Assert.assertEquals(quote,  5150L);
	}
	
	@Test
	public void testDrugs() {
		
		quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.DRUGS, convertBoolean(drugs)).execute();
		Assert.assertEquals(quote,  5150L);
	}
	
	@Test
	public void testDailyExercise() {
		
		quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.DAILY_EXERCISE, convertBoolean(dailyExercise)).execute();
		Assert.assertEquals(quote,  4850L);
	}
	
	
	/**
	 * Takes Yes or No as input and return boolean counterparts.
	 * @param reply
	 * @return
	 */
	private static boolean convertBoolean(String reply){
		if(reply != null && !reply.trim().isEmpty() && reply.equalsIgnoreCase("yes"))
		return true;
		else if (reply != null && !reply.trim().isEmpty() && reply.equalsIgnoreCase("no")) return false;
		else throw new RuntimeException("Invalid Input.");
	}
	
	@After
	public void tearDown() {
	}


}
