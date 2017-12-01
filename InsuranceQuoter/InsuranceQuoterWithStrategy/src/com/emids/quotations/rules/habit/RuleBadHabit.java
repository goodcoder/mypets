package com.emids.quotations.rules.habit;

import com.emids.quotations.rules.Rule;


public class RuleBadHabit extends Rule {

	@Override
	public long execute() {
		return additionalPremium(3);
		
	}

}
