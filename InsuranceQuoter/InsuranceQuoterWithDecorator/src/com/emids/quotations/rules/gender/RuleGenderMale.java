package com.emids.quotations.rules.gender;

import com.emids.quotations.rules.Rule;


public class RuleGenderMale extends Rule {

	@Override
	public long execute() {
		return additionalPremium(2);
		
	}

}
