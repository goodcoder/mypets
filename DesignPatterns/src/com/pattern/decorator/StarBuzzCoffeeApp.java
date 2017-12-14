package com.pattern.decorator;

import com.pattern.decorator.impl.Decafe;
import com.pattern.decorator.impl.Espresso;
import com.pattern.decorator.impl.HouseBlend;
import com.pattern.decorator.impl.Mocha;
import com.pattern.decorator.impl.Soy;
import com.pattern.decorator.impl.Whip;

public class StarBuzzCoffeeApp {

	
	public static void main(String[] args) {
		
		Beverage beverage1 = new Espresso();
		System.out.println(beverage1.getDescription()+" $"+beverage1.cost());
		
		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
		
		Beverage beverage3 = new Decafe();
		beverage3 = new Mocha(beverage3);
		beverage3 = new Soy(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription()+" $"+beverage3.cost());
	}

}
