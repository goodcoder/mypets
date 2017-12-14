package com.pattern.decorator.impl;

import com.pattern.decorator.Beverage;
import com.pattern.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

	Beverage beverage;
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Whip";
	}
	
	@Override
	public double cost() {
		someAdditionalFunctionality();  // Extra functionality BEFORE delegating to Decorated object method
		return .10 + beverage.cost();
	}

	/*NOTE : Please refer https://tinyurl.com/k8wkath  (Decorator on wikipedia)  section "Structure". 
	 * I have also added UML diagram in UML folder 
	 * Over there it's mentioned we can add additional behavior/functionality Before or after delegating call to Decorated.
	 * */
	@Override
	public void someAdditionalFunctionality() {
		System.out.println("Enjoy some extra Whip!  Free coupon for you.");
	}

}
