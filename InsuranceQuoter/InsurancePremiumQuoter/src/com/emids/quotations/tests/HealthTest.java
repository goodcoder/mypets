
package com.emids.quotations.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.enums.HealthRulesExecutor;


/**
 * @author Shekhar Arya
 * 
 * Unit test to test Health of applicant
 *
 */
public class HealthTest {
	
	private long quote;
	private String hypertension;
	private String bloodPressure;
	private String bloodSugar;
	private String overWeight;

	@Before
	public void setUp()  {
		 quote = QuotationGeneratorConstants.BASE_PREMIUM;
		 hypertension = "yes";
		 bloodPressure = "yes";
		 bloodSugar = "yes";
		 overWeight = "yes";
	}


	@Test
	public void testHyperTension() {
		
		quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.HYPERTENSION, convertBoolean(hypertension)).execute();
		Assert.assertEquals(quote,  5050L);
	}
	
	@Test
	public void testBloodPressure() {
		
		quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.BLOOD_PRESSURE, convertBoolean(bloodPressure)).execute();
		Assert.assertEquals(quote,  5050L);
	}
	
	@Test
	public void testBloodSugar() {
		
		quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.BLOOD_SUGAR, convertBoolean(bloodSugar)).execute();
		Assert.assertEquals(quote,  5050L);
	}
	
	@Test
	public void testOverWeight() {
		
		quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.OVERWEIGHT, convertBoolean(overWeight)).execute();
		Assert.assertEquals(quote,  5050L);
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
