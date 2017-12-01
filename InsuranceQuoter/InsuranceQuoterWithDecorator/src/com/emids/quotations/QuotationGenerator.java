package com.emids.quotations;

import com.emids.quotations.interfaces.IRule;
import com.emids.quotations.rules.age.RuleAge18To25;
import com.emids.quotations.rules.age.RuleAge25To30;
import com.emids.quotations.rules.age.RuleAgeLess18;
import com.emids.quotations.rules.gender.RuleGenderMale;
import com.emids.quotations.rules.habit.RuleBadHabit;
import com.emids.quotations.rules.habit.RuleGoodHabit;
import com.emids.quotations.rules.health.RuleHealth;

/**
 * @author Shekhar Arya
 *
 */
public class QuotationGenerator {

	static long  quote = QuotationGeneratorConstants.BASE_PREMIUM;
	private IRule iRule;
	
	public void setRule(IRule aRule){
		iRule = aRule;
	}
	
	public static void main(String[] args) {
		
		int age = 24;
		
		boolean male = true;
		
		boolean hypertension = false;
		boolean bloodPressure = false;
		boolean bloodSugar = false;
		boolean overWeight = true;
		
		boolean alcohol = true;
		boolean drugs = false;
		boolean smoking = false;
		boolean dailyExercise = true;
		
		QuotationGenerator gen = new QuotationGenerator();
		
		// Apply Age rules
		
		if (age <= 18) {  // TODO: Instead of if-else here in caller. I could implement MATCHER somewhere in Rules Abstract class or something like that
			gen.setRule(new RuleAgeLess18());  // Identify behavior/algo that changes. Encapsulate them and Inject Behavior interchangebly.  i.e Strategy Design Pattern
		} else if (18 < age && age <= 25) {
			gen.setRule(new RuleAge18To25());
		} else if (25 < age && age <= 30) {
			gen.setRule(new RuleAge25To30());
		}
		
		quote = quote + gen.iRule.execute();
		
		// Gender
		
		if (male) {
			gen.setRule(new RuleGenderMale());
			quote = quote + gen.iRule.execute();
		} 
		quote = quote + gen.iRule.execute();
		/// Health
		
		if (hypertension ) {
			gen.setRule(new RuleHealth());
			quote = quote + gen.iRule.execute();
		} 
		if (bloodPressure ) {
			gen.setRule(new RuleHealth());
			quote = quote + gen.iRule.execute();
		} 
		if (bloodSugar ) {
			gen.setRule(new RuleHealth());
			quote = quote + gen.iRule.execute();
		} 
		if (overWeight) {
			gen.setRule(new RuleHealth());
			quote = quote + gen.iRule.execute();
		} 
		
		quote = quote + gen.iRule.execute();
			
	  /// Habits
		
		if (alcohol) {
			gen.setRule(new RuleBadHabit());  // Inject Behavior  i.e Strategy Design Pattern
			quote = quote + gen.iRule.execute();
		} 
		if (drugs) {
			gen.setRule(new RuleBadHabit());  // Inject Behavior  i.e Strategy Design Pattern
			quote = quote + gen.iRule.execute();
		} 
		if (smoking) {
			gen.setRule(new RuleBadHabit());  // Inject Behavior  i.e Strategy Design Pattern
			quote = quote + gen.iRule.execute();
		} 
		if (dailyExercise ) {
			gen.setRule(new RuleGoodHabit());  // Inject Behavior  i.e Strategy Design Pattern
			quote = quote + gen.iRule.execute();
		} 
		quote = quote + gen.iRule.execute();
		System.out.println(quote);
	}
	
	
}
