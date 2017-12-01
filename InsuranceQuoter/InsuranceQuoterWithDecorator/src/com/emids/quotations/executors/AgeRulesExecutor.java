package com.emids.quotations.executors;

import com.emids.quotations.rules.age.RuleAge18To25;
import com.emids.quotations.rules.age.RuleAge25To30;
import com.emids.quotations.rules.age.RuleAgeLess18;

public class AgeRulesExecutor extends RulesExecutor {
	
	int age = 24;
	
	AgeRulesExecutor(int age){
		matcher(age);
	}

	private void matcher(int age) {
		// Apply Age rules
/*
		if (age <= 18) {  // TODO: Instead of if-else here in caller. I could implement MATCHER somewhere in Rules Abstract class or something like that
			gen.setRule(new RuleAgeLess18());  // Inject Behavior  i.e Strategy Design Pattern
		} else if (18 < age && age <= 25) {
			gen.setRule(new RuleAge18To25());
		} else if (25 < age && age <= 30) {
			gen.setRule(new RuleAge25To30());
		}*/
	}

}
