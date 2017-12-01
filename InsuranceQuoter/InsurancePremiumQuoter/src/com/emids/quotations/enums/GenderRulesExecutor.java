package com.emids.quotations.enums;

import com.emids.quotations.QuotationGeneratorConstants;
import com.emids.quotations.interfaces.GeneralStrategy;

/**
 * @author Shekhar Arya
 *
 **This class parses Gender rules and calculate premium increment/decrement based on gender.
 */
public enum GenderRulesExecutor implements GeneralStrategy {
	GENDER{

		@Override
		public boolean match(String gender, boolean condition) {
			if(gender.equalsIgnoreCase(QuotationGeneratorConstants.MALE) &&  condition) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(2);
		}
	},
	
	DEFAULT {

		@Override
		public boolean match(String context, boolean condition) {
			return false;
		}

		@Override
		public long execute() {
			System.out.println("Not a male for sure.)");
			return 0;
		}
	};
	
	

	public static GenderRulesExecutor getPremiumDelta(String gender, boolean condition){
		for(GenderRulesExecutor  exe : values()){
			if(exe.match(gender, condition)){
				return exe;
			}
		}
		return DEFAULT;
	}
	
	protected long additionalPremium(int percent){
		return base * percent / 100;
	}


}
