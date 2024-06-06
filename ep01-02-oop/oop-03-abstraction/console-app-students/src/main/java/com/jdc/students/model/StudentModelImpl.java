package com.jdc.students.model;

import java.util.Arrays;

public class StudentModelImpl implements StudentModel {
	
	private Node firstNode;
	private int id;

	@Override
	public StudentOutput[] search(String keyword) {
		
		var result = new StudentOutput[0];
		
		if(null == firstNode) {
			return result;
		}
		
		return firstNode.search(keyword, result);
	}

	@Override
	public StudentOutput createStudent(StudentForm form) {
		var student = Student.create(++ id, form);
		var newNode = new Node(student);
		
		if(null == firstNode) {
			firstNode = newNode;
		} else {
			firstNode.add(newNode);
		}
		
		return student.output();
	}

	@Override
	public StudentOutput update(int id, StudentForm form) {
		
		if(null != firstNode) {
			return firstNode.update(id, form);
		}
		
		return null;
	}

	@Override
	public StudentOutput findById(int id) {
		
		if(null != firstNode) {
			return firstNode.findById(id);
		}
		
		return null;
	}

	private static record Student(int id, String name, String phone, String email, String address) {
		
		public static Student create(int id, StudentForm form) {
			return new Student(id, form.getName(), form.getPhone(), form.getEmail(), form.getAddress());
		}
		
		public StudentOutput output() {
			return new StudentOutput(id, name, phone, email, address);
		}

		public boolean match(String keyword) {
			return name.toLowerCase().contains(keyword.toLowerCase())
					|| phone.toLowerCase().contains(keyword.toLowerCase())
					|| email.toLowerCase().contains(keyword.toLowerCase())
					|| address.toLowerCase().contains(keyword.toLowerCase());
		}
	}

	private static class Node {

		private Student data;
		private Node next;
		
		public Node(Student data) {
			super();
			this.data = data;
		}

		public StudentOutput[] search(String keyword, StudentOutput[] array) {
			
			var result = array;
			
			if(data.match(keyword)) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = data.output();
			}
			
			if(null != next) {
				return next.search(keyword, result);
			}
			
			return result;
		}

		public StudentOutput findById(int id) {
			if(data.id() == id) {
				return data.output();
			} 
			
			if(null != next) {
				return next.findById(id);
			}
			
			return null;
		}
		
		public StudentOutput update(int id, StudentForm form) {
			
			if(data.id() == id) {
				this.data = Student.create(id, form);
				return data.output();
			}
			
			if(null != next) {
				return next.update(id, form);
			}
			
			return null;
		}



		public void add(Node newNode) {
			if(null == next) {
				next = newNode;
			} else {
				next.add(newNode);
			}
		}

	}
}
