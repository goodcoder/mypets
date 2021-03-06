package com.pattern.decorator.impl;

import com.pattern.decorator.Beverage;
import com.pattern.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Mocha";
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
		return .20;
	}
	
	
		
	
	
	
	
	
	
/* Note : Later // I leveraged calculateCondimentCost() to show additional functionality
 * 
 * NOTE : Please refer https://tinyurl.com/k8wkath  (Decorator on wikipedia)  section "Structure". 
 * I have also added UML diagram in UML folder 
 * Over there it's mentioned we can add additional behavior/functionality Before or after delegating call to Decorated.
 * 
	@Override
	public void someAdditionalFunctionality() {
		System.out.println("Enjoy some extra Mocha!  Free coupon for you.");
	}
*/


}
