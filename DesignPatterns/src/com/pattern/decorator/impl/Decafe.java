package com.pattern.decorator.impl;

import com.pattern.decorator.Beverage;

public class Decafe extends Beverage {
 
	public Decafe(){
			description = "Decafe";
		}
	
	
	@Override
	public double cost() {
		return 1.05;
	}

}
