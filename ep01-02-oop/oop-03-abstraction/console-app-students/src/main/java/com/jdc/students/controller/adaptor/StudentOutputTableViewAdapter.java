package com.jdc.students.controller.adaptor;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.students.model.StudentOutput;

public class StudentOutputTableViewAdapter implements TableViewModel{

	private StudentOutput[] array;
	
	private static final String ID = "ID";
	private static final String NAME = "Name";
	private static final String PHONE = "Phone";
	private static final String EMAIL = "Email";
	private static final String ADDRESS = "Address";
	
	private int idSize = ID.length() + 2;
	private int nameSize = NAME.length() + 2; 
	private int phoneSize = PHONE.length() + 2;
	private int emailSize = EMAIL.length() + 2;
	private int addressSize = ADDRESS.length() + 2;
	
	
	public StudentOutputTableViewAdapter(StudentOutput[] array) {
		super();
		this.array = array;
		
		for(var data : this.array) {
			var id = String.valueOf(data.getId()).length() + 2;
			idSize = id > idSize ? id : idSize;
			
			var name = data.getName().length() + 2;
			nameSize = name > nameSize ? name : nameSize;
			
			var phone = data.getPhone().length() + 2;
			phoneSize = phone > phoneSize ? phone : phoneSize;
			
			var email = data.getEmail().length() + 2;
			emailSize = email > emailSize ? email : emailSize;
			
			var addr = data.getAddress().length() + 2;
			addressSize = addr > addressSize ? addr : addressSize;
		}	
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String header() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] rows() {
		// TODO Auto-generated method stub
		return null;
	}

}
