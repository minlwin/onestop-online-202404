package com.jdc.demo.constants;

public enum Days implements DisplayNameEnable{

	MON("Monday") {

		@Override
		public boolean isWeekend() {
			return false;
		}
	}, 
	TUE("Tuesday") {

		@Override
		public boolean isWeekend() {
			return false;
		}
	}, 
	WED("Wednesday") {

		@Override
		public boolean isWeekend() {
			return false;
		}
	}, 
	THU("Thursday") {

		@Override
		public boolean isWeekend() {
			return false;
		}
	}, 
	FRI("Friday") {

		@Override
		public boolean isWeekend() {
			return false;
		}
	}, 
	SAT("Saturday") {

		@Override
		public boolean isWeekend() {
			return true;
		}
	}, 
	SUN("Sunday") {

		@Override
		public boolean isWeekend() {
			return true;
		}
	};
	
	// Instance Variable
	private String displayName;
	
	private Days(String displayName) {
		this.displayName = displayName;
	}
	
	// Instance Method
	public String getDisplayName() {
		return displayName;
	}
	
	public int getValue() {
		return ordinal() + 1;
	}
	
	public abstract boolean isWeekend();
}
