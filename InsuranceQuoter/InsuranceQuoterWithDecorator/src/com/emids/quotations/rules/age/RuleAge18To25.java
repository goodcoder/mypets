package com.emids.quotations.rules.age;

import com.emids.quotations.rules.Rule;


public class RuleAge18To25 extends Rule {

	@Override
	public long execute() {
		return additionalPremium(10);
	}

}
