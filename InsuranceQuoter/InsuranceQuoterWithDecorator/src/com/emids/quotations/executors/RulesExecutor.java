package com.emids.quotations.executors;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.interfaces.IRule;

public abstract class RulesExecutor {

	
	static long  quote = QuotationGeneratorConstants.BASE_PREMIUM;
	private IRule iRule;
	
	public void setRule(IRule aRule){
		iRule = aRule;
	}
	
	
	
}
