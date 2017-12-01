package com.emids.quotations.enums;

import com.emids.quotations.interfaces.SingleConditionStrategy;

/**
 * @author Shekhar Arya
 *
 *This class parses Age rules and calculate premium increment based on age.
 */
public enum AgeRulesExecutor implements SingleConditionStrategy {
	
	
	AGE_LESS_THEN_18{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) <= 18 && Integer.valueOf(age) <=0) return true;
			else return false;
		}

		@Override
		public long execute() {
			return 0;
		}
	},
	
	AGE_18_25{

		@Override
		public boolean match(String age) {
			if(Integer.valueOf(age) > 18 && Integer.valueOf(age) <=25) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(10);
		}
	},
	AGE_25_30{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) > 25 && Integer.valueOf(age) <=30) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(20);
		}
	},
	AGE_30_35{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) > 30 && Integer.valueOf(age) <=35) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(30);
		}
	},
	AGE_35_40{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) > 35 && Integer.valueOf(age) <=40) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(40);
		}
	},
	AGE_40_45{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) > 40 && Integer.valueOf(age) <=45) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(60);
		}
	},
	AGE_45_50{

		@Override
		public boolean match( String age) {
			if(Integer.valueOf(age) > 45 && Integer.valueOf(age) <=50) return true;
			else return false;
		}

		@Override
		public long execute() {
			return additionalPremium(80);
		}
	},
	
	DEFAULT {

		@Override
		public boolean match( String age) {
			return false;
		}

		@Override
		public long execute() {
			System.out.println("Immortals or unborns don't need insurances. They are safe :)");
			return 0;
		}
	};
	
	
	
	/**
	 * Calculates premium delta
	 * @param age
	 * @return
	 */
	public static AgeRulesExecutor getPremiumDelta(String age){
		for(AgeRulesExecutor  exe : values()){
			if(exe.match(age)){
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
