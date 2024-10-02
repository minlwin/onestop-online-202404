package com.jdc.spring.trx.dto;

public record BalanceHistoryForm(
		String accountNum, 
		int version, 
		int lastAmount, 
		int trxId, 
		boolean debit,
		int trxAmount, 
		String remark) {
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String accountNum;
		private int version;
		private int lastAmount;
		private int trxId;
		private boolean debit;
		private int trxAmount;
		private String remark;

		public BalanceHistoryForm build() {
			return new BalanceHistoryForm(accountNum, version, lastAmount, trxId, debit, trxAmount, remark);
		}

		public Builder accountNum(String accountNum) {
			this.accountNum = accountNum;
			return this;
		}

		public Builder nextVersion(int version) {
			this.version = version;
			return this;
		}

		public Builder lastAmount(int lastAmount) {
			this.lastAmount = lastAmount;
			return this;
		}

		public Builder trxId(int trxId) {
			this.trxId = trxId;
			return this;
		}

		public Builder isDebit(boolean debit) {
			this.debit = debit;
			return this;
		}

		public Builder trxAmount(int trxAmount) {
			this.trxAmount = trxAmount;
			return this;
		}

		public Builder remark(String remark) {
			this.remark = remark;
			return this;
		}

	}
}
