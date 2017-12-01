package com.emids.quotations.rules.age;

import com.emids.quotations.rules.Rule;


public class RuleAgeLess18 extends Rule {

	@Override
	public long execute() {
		return additionalPremium(0);
		
	}

}
