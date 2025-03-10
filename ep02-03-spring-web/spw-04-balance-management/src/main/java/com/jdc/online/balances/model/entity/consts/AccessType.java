package com.jdc.online.balances.model.entity.consts;

public enum AccessType {
	Login, Logout, SignUp {
		@Override
		public String getDisplayName() {
			return "Sign Up";
		}
	}, Timeout;
	
	public String getDisplayName() {
		return this.name();
	}
}
