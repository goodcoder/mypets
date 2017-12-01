package com.emids.quotations.rules;

import com.emids.quotations.interfaces.IRule;

public abstract class Rule implements IRule {
	
	/**
	 * Here Rule class is abstract class as Beverage abstarct class in H.P book.
	 * @param percent
	 * @return
	 */
	protected long additionalPremium(int percent){
		return base * percent / 100;
	}

}
