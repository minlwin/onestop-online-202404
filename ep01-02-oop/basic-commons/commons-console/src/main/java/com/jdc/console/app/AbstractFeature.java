package com.jdc.console.app;

public abstract class AbstractFeature {

	private int id;
	private String name;
	
	public AbstractFeature(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public abstract void doBusiness();
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void showMenu() {
		System.out.printf("%d : %s%n", id, name);
	}
}
