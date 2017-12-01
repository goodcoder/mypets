/**
 * 
 */
package com.emids.quotations.enums;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.interfaces.GeneralStrategy;

/**
 * @author Shekhar Arya
 * 
 * This class parses Habit rules and calculate premium increment/decrement based on habits.
 */
 
public enum HabitRulesExecutor implements GeneralStrategy{
	BAD_HABIT{

		@Override
		public boolean match(String habit, boolean condition) {
			if((habit.equalsIgnoreCase(QuotationGeneratorConstants.ALCOHOL) || habit.equalsIgnoreCase(QuotationGeneratorConstants.SMOKING) || habit.equalsIgnoreCase(QuotationGeneratorConstants.DRUGS)) &&  condition) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(3);
		}
	},
	GOOD_HABIT{

		@Override
		public boolean match(String habit, boolean condition) {
			if(habit.equalsIgnoreCase(QuotationGeneratorConstants.DAILY_EXERCISE) &&  condition) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(-3);
		}
	},
	
	
	DEFAULT {

		@Override
		public boolean match(String context, boolean condition) {
			return false;
		}

		@Override
		public long execute() {
			return 0;
		}
	};
	


	/**
	 * @param habit
	 * @param condition
	 * @return
	 */
	public static HabitRulesExecutor getPremiumDelta(String habit, boolean condition){
		for(HabitRulesExecutor  exe : values()){
			if(exe.match(habit, condition)){
				return exe;
			}
		}
		return DEFAULT;
	}
	
	/**
	 * @param percent
	 * @return
	 */
	protected long additionalPremium(int percent){
		return base * percent / 100;
	}

}
