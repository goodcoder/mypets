package com.emids.quotations.rules.age;

import com.emids.quotations.rules.Rule;


public class RuleAge30To35 extends Rule {

	@Override
	public long execute() {
		return additionalPremium(30);
	}

}
