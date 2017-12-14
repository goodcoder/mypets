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
		return .15 + beverage.cost();
	}

	@Override
	public void someAdditionalFunctionality() {
		//Nothing for SOY
	}

}
