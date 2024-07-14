package com.jdc.generics;

public class NumberWrapper<T extends Number> implements Wrapper<T>{

	private T data;
	
	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

}
