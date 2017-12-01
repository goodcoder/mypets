package com.emids.quotations.rules.health;

import com.emids.quotations.interfaces.IRule;
import com.emids.quotations.rules.Rule;


public class RuleHealth extends Rule {

	IRule  rule ;
	
	public RuleHealth(IRule aRule){
		this.rule = aRule;
	}
	
	public RuleHealth(){
	}
	
	@Override
	public long execute() {
		return additionalPremium(1);
		//return rule.execute() + additionalPremium(1);
		
	}

}
