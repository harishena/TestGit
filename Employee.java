package com.employee;

public class Employee {
	
	private String acno;
	private String fname;
	private String lname;
	private String age;
	private String gender;	
	private String ageErrorDesc;
	private String genderErrorDesc;
	

	public Employee(String acno, String fname, String lname, String age, String gender) {
		super();
		this.acno = acno;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
	}
	
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	public String getAgeErrorDesc() {
		return ageErrorDesc;
	}

	public void setAgeErrorDesc(String ageErrorDesc) {
		this.ageErrorDesc = ageErrorDesc;
	}

	public String getGenderErrorDesc() {
		return genderErrorDesc;
	}

	public void setGenderErrorDesc(String genderErrorDesc) {
		this.genderErrorDesc = genderErrorDesc;
	}

	@Override
	public String toString() {
		return "Employee [acno=" + acno + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender="
				+ gender + ", ageErrorDesc=" + ageErrorDesc + ", genderErrorDesc=" + genderErrorDesc + "]";
	}

	
	
	
	
	

}
