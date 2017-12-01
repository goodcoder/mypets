package com.emids.quotations.rules.age;

import com.emids.quotations.rules.Rule;


public class RuleAge25To30 extends Rule {

	@Override
	public long execute() {
		return additionalPremium(20);
		
	}

}
