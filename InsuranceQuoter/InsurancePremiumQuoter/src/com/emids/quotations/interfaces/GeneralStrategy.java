package com.emids.quotations.interfaces;

/**
 * @author Shekhar Arya
 *
 */
public interface GeneralStrategy extends Strategy {
	
	boolean match(String context, boolean condition);

}
