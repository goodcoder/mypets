package com.emids.quotations.interfaces;

import com.emids.quotations.QuotationGeneratorConstants;

public interface IRule {
	
	long base = QuotationGeneratorConstants.BASE_PREMIUM;
	
	 long execute();

}
