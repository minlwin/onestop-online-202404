package com.jdc.console.app.component;

public class TableView implements Drawable{

	private TableViewModel model;
	
	public TableView(TableViewModel model) {
		super();
		this.model = model;
	}

	@Override
	public void draw() {
		drawLine(model.maxSize());
		System.out.println(model.header());
		drawLine(model.maxSize());
		
		for(var row : model.rows()) {
			System.out.println(row);
		}
		drawLine(model.maxSize());
	}

}
