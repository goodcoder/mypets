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
		
		IRule basic = new BasicPremiumRule();
		quote = basic.execute();
		
		// Apply Age rules
		
		if (age <= 18) {  
			quote = quote + new RuleAgeLess18().execute();  
		} else if (18 < age && age <= 25) {
			quote = quote + new RuleAge18To25().execute();  
		} else if (25 < age && age <= 30) {
			quote = quote + new RuleAge25To30().execute();  
		}
		
		// Gender
		
		if (male) {
			quote = quote + new RuleGenderMale().execute();  
		} 
		/// Health
		
		if (hypertension ) {
			quote = quote + new RuleHealth().execute();
			//quote = quote + new RuleHealth(basic).execute();
		} 
		if (bloodPressure ) {
			quote = quote + new RuleHealth().execute();
		} 
		if (bloodSugar ) {
			quote = quote + new RuleHealth().execute();
		} 
		if (overWeight) {
			quote = quote + new RuleHealth().execute();
		} 
		
		
		/// Habits
		
		if (alcohol) {
			quote = quote + new RuleBadHabit().execute();
		} 
		if (drugs) {
			quote = quote + new RuleBadHabit().execute();
		} 
		if (smoking) {
			quote = quote + new RuleBadHabit().execute();
		} 
		if (dailyExercise ) {
			quote = quote + new RuleGoodHabit().execute();
		} 
	
		System.out.println(quote);
	}
	
	
}
