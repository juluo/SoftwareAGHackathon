package org.softwareag.hackthon.service;

public class Login {

	public String name;

	public int phone;

	public String gender;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", phone=" + phone + ", gender=" + gender + "]";
	}

}
