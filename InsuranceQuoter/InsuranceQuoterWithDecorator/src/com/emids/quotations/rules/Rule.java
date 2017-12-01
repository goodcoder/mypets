package com.emids.quotations.rules;

import com.emids.quotations.interfaces.IRule;

public abstract class Rule implements IRule {
	
	/**
	 * @param percent
	 * @return
	 */
	protected long additionalPremium(int percent){
		return base * percent / 100;
	}

}
