package com.jdc.online.balances.model;

import java.util.List;

public record PageResult<T>(
		List<T> contents, 
		long count, 
		int size, 
		int page) {
	
	public static <T> Builder<T> builder() {
		return new Builder<>();
	}

	public static class Builder<T> {
		private List<T> contents;
		private long count;
		private int size;
		private int page;

		public Builder<T> contents(List<T> contents) {
			this.contents = contents;
			return this;
		}

		public Builder<T> count(long count) {
			this.count = count;
			return this;
		}

		public Builder<T> size(int size) {
			this.size = size;
			return this;
		}

		public Builder<T> page(int page) {
			this.page = page;
			return this;
		}

		public PageResult<T> build() {
			return new PageResult<>(contents, count, size, page);
		}
	}
}
