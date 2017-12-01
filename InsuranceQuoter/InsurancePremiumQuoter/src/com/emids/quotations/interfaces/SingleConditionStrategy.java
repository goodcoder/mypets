package com.emids.quotations.interfaces;

/**
 * @author Shekhar Arya
 *
 */
public interface SingleConditionStrategy extends Strategy{
	
	boolean match(String condition);
}
