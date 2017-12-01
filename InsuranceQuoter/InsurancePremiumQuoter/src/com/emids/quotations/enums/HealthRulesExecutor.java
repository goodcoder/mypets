package com.emids.quotations.enums;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.interfaces.GeneralStrategy;

/**
 * @author Shekhar Arya
 *
 **This class parses Health rules and calculate premium increment/decrement based on health.
 */

public enum HealthRulesExecutor implements GeneralStrategy {
	
	HEALTH{

		@Override
		public boolean match(String habit, boolean condition) {
			if((habit.equalsIgnoreCase(QuotationGeneratorConstants.HYPERTENSION) || habit.equalsIgnoreCase(QuotationGeneratorConstants.BLOOD_PRESSURE) || habit.equalsIgnoreCase(QuotationGeneratorConstants.BLOOD_SUGAR) || habit.equalsIgnoreCase(QuotationGeneratorConstants.OVERWEIGHT))&&  condition) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(1);
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
	 * @param health
	 * @param condition
	 * @return
	 */
	public static HealthRulesExecutor getPremiumDelta(String health, boolean condition){
		for(HealthRulesExecutor  exe : values()){
			if(exe.match(health, condition)){
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
