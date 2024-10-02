package com.jdc.spring.trx.dto;

public record AmountUpdateForm(
		String accountNum,
		int amount, 
		int version) {
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String accountNum;
		private int amount;
		private int version;
		
		public AmountUpdateForm build() {
			return new AmountUpdateForm(accountNum, amount, version);
		}

		public Builder accountNum(String accountNum) {
			this.accountNum = accountNum;
			return this;
		}

		public Builder updatedAmount(int amount) {
			this.amount = amount;
			return this;
		}

		public Builder nextVersion(int version) {
			this.version = version;
			return this;
		}
	}
}
