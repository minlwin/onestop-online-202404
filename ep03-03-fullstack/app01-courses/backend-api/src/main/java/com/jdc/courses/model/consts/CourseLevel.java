package com.jdc.courses.model.consts;

public enum CourseLevel {
	Basic, Intermediate, Advance, AllInOne {
		@Override
		public String getDisplayName() {
			return "All In One";
		}
	};
	
	public String getDisplayName() {
		return name();
	}
}
