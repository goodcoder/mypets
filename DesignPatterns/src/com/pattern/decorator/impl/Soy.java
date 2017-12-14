package com.pattern.decorator.impl;

import com.pattern.decorator.Beverage;
import com.pattern.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

	private Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Soy";
	}
	
	@Override
	public double cost() {
		double cost = beverage.cost();
		double condCost = calculateCondimentCost();  // Extra functionality AFTER delegating to Decorated object method
		//someAdditionalFunctionality();  // Extra functionality AFTER delegating to Decorated object method
		return condCost + cost;
	}

	@Override
	public double calculateCondimentCost() {
		// Or do some complex calculation to find cost
		return .15;
	}

	

}
