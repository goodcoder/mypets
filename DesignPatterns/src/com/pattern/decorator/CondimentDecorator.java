package com.pattern.decorator;

public abstract class CondimentDecorator extends Beverage {

   public abstract String getDescription();
  
   public abstract double calculateCondimentCost();
   
   //public abstract void someAdditionalFunctionality();  // I leveraged calculateCondimentCost() to show additional functionality
}
