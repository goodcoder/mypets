
package com.emids.quotations.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.enums.AgeRulesExecutor;
import com.emids.quotations.enums.GenderRulesExecutor;

/**
 * @author Shekhar Arya
 * 
 * Unit test to test personal Characteristics of applicant
 *
 */
public class CharacteristicsTest {
	private long quote;
	private String age;
	private String gender;

	@Before
	public void setUp()  {
		 quote = QuotationGeneratorConstants.BASE_PREMIUM;
		 age = "34";
		 gender = "Male";
	}


	@Test
	public void testAge() {
		
		quote = quote + AgeRulesExecutor.getPremiumDelta(age).execute();
		Assert.assertEquals(quote,  6500L);
	}
	
	@Test
	public void testGender() {
		
		quote = quote + GenderRulesExecutor.getPremiumDelta(gender, true).execute();
		Assert.assertEquals(quote,  5100L);
	}
	
	
	@After
	public void tearDown() {
	}

}
