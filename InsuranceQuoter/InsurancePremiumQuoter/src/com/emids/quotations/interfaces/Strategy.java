package com.emids.quotations.interfaces;

import com.emids.quotations.QuotationGeneratorConstants;

/**
 * @author Shekhar Arya
 * 
 * Base Strategy Interface
 */
public interface Strategy {
	
	
	long base = QuotationGeneratorConstants.BASE_PREMIUM;
	
	long execute();

}
