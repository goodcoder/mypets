package com.emids.quotations;

import com.emids.quotations.rules.Rule;

public class BasicPremiumRule extends Rule {

	@Override
	public long execute() {
		// TODO Auto-generated method stub
		return QuotationGeneratorConstants.BASE_PREMIUM;
	}

}
