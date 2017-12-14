package com.pattern.decorator.impl;

import com.pattern.decorator.Beverage;

public class HouseBlend extends Beverage {
 
	public HouseBlend(){
			description = "HouseBlend";
		}
	
	
	@Override
	public double cost() {
		return .89;
	}

}
