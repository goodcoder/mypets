package com.emids.quotations;

import java.text.NumberFormat;
import java.util.Scanner;

import com.emids.quotations.enums.AgeRulesExecutor;
import com.emids.quotations.enums.GenderRulesExecutor;
import com.emids.quotations.enums.HabitRulesExecutor;
import com.emids.quotations.enums.HealthRulesExecutor;

/**
 * @author Shekhar Arya
 *
 */
public class QuotationGenerator {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        /*  Enter Personal Characteristics */
		System.out.println("Enter your name :");
		String name = sc.next();

		System.out.println("Enter your age :");
		String age = sc.next();

		System.out.println("Enter your gender :");
		String gender = sc.next();
		
		/*  Enter Health Characteristics */
		
		System.out.println("Do you have hypertension?  :");
		String hypertension = sc.next();

		System.out.println("Do you have blood pressure?  :");
		String bloodPressure = sc.next();

		System.out.println("Do you have blood sugar?  :");
		String bloodSugar = sc.next();
		
		System.out.println("Are you overweight?  :");
		String overweight = sc.next();
		
		/*  Enter Habits */
		
		System.out.println("Do you smoke?  :");
		String smoking = sc.next();

		System.out.println("Do you drink alcohol?  :");
		String alcohol = sc.next();

		System.out.println("Do you do drugs?  :");
		String drugs = sc.next();
		
		System.out.println("Are you do daily exercise?  :");
		String dailyExercise = sc.next();
		
		/////////////
		
		long quote = QuotationGeneratorConstants.BASE_PREMIUM;
		
		if(age != null && !age.trim().isEmpty()){
			quote = quote + AgeRulesExecutor.getPremiumDelta(age).execute();
		}
		
		if(gender != null && !gender.trim().isEmpty()){
			quote = quote + GenderRulesExecutor.getPremiumDelta(gender, true).execute();
		}
		/////////////
		
		if(hypertension != null && !hypertension.trim().isEmpty()){
			quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.HYPERTENSION, convertBoolean(hypertension)).execute();
		}
	
		if(bloodPressure != null && !bloodPressure.trim().isEmpty()){
			quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.BLOOD_PRESSURE, convertBoolean(bloodPressure)).execute();
		}
		
		if(bloodSugar != null && !bloodSugar.trim().isEmpty()){
			quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.BLOOD_SUGAR, convertBoolean(bloodSugar)).execute();
		}
		
		if(overweight != null && !overweight.trim().isEmpty()){
			quote = quote + HealthRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.OVERWEIGHT, convertBoolean(overweight)).execute();
		}
		////////////
		
		if(smoking != null && !smoking.trim().isEmpty()){
			quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.SMOKING, convertBoolean(smoking)).execute();
		}
		
		if(alcohol != null && !alcohol.trim().isEmpty()){
			quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.ALCOHOL, convertBoolean(alcohol)).execute();
		}
		
		if(drugs != null && !drugs.trim().isEmpty()){
			quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.DRUGS, convertBoolean(drugs)).execute();
		}
		
		if(dailyExercise != null && !dailyExercise.trim().isEmpty()){
			quote = quote + HabitRulesExecutor.getPremiumDelta(QuotationGeneratorConstants.DAILY_EXERCISE, convertBoolean(dailyExercise)).execute();
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		
		
		System.out.println("Health Insurance Premium for Mr."+name+": Rs. "+numberFormat.format(quote));
		sc.close();

	}
	
	/**
	 * Takes Yes or No as input and return boolean counterparts.
	 * @param reply
	 * @return
	 */
	private static boolean convertBoolean(String reply){
		if(reply != null && !reply.trim().isEmpty() && reply.equalsIgnoreCase("yes"))
		return true;
		else if (reply != null && !reply.trim().isEmpty() && reply.equalsIgnoreCase("no")) return false;
		else throw new RuntimeException("Invalid Input.");
	}

}
