package com.emids.quotations.rules.health;

import com.emids.quotations.rules.Rule;


public class RuleHealth extends Rule {

	@Override
	public long execute() {
		return additionalPremium(1);
		
	}

}
