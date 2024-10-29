package com.nareshit.model;

public class Student {
	private String firstName;
	private String lastName;
	private String address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setHello(Student s1) {
		this.firstName = s1.getFirstName();
		this.lastName = s1.getLastName();
		this.address = s1.getAddress();
	}
	
	public String getAddress() {
		return address;
	}
	
	public Student(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public Student(Student s1) {
		this.firstName = s1.getFirstName();
		this.lastName = s1.getLastName();
		this.address = s1.getAddress();
	}
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
	
}
