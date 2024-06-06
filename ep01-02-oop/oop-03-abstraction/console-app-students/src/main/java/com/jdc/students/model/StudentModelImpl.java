package com.jdc.students.model;

public class StudentModelImpl implements StudentModel {
	
	private Node firstNode;
	private int id;

	@Override
	public StudentOutput[] search(String keyword) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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
	}

	private static class Node {

		private Student data;
		private Node next;
		
		public Node(Student data) {
			super();
			this.data = data;
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

		public void add(Node newNode) {
			if(null == next) {
				next = newNode;
			} else {
				next.add(newNode);
			}
		}

		public Student getData() {
			return data;
		}

		public void setData(Student data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
