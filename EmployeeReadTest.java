package com.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeReadTest {
	
	public static boolean isNumeric(String s) {
		if (s == null || s.equals("")) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		 List<Employee> listOfEmployees=new ArrayList<>();
	 
		 List<Employee> listOfEmployeesWithError=new ArrayList<>(); //this needs to be write to excel back.
		
		 Employee excelRow1=new Employee("100", "hari", "enaganti", "18", "MALE");	//vaid
		 Employee excelRow2=new Employee("101", "upen", "rangu", "eighteen", "");	//invalid age and blank gender
		 Employee excelRow3=new Employee("102", "venkat", "reddy","18", null);	
		 
		 listOfEmployees.add(excelRow1);
		 listOfEmployees.add(excelRow2);		 
		 listOfEmployees.add(excelRow3);		 
		 
		 listOfEmployees.parallelStream().forEach(employee->{			 		 
			 //if age is blank
			 if(employee.getAge()==null) {
				 employee.setAgeErrorDesc("Age is mandatory,you must enter");				 
			 }else if(!isNumeric(employee.getAge())) {
				 employee.setAgeErrorDesc("Age is numeric, please enter valid number");		
				 }
		 			 
			//if gender is blank
			 if(employee.getGender()==null || employee.getGender()=="") {
				 employee.setGenderErrorDesc("Gender is mandatory");				 						 
			 }			 
			listOfEmployeesWithError.add(employee);		 
		 
		 });	
		 
		 
		 listOfEmployeesWithError.parallelStream().forEach(employee->System.out.println(employee));
		 
		 
		/* for(Employee e:listOfEmployeesWithError) {
			 
			 System.out.print(e.toString());
			 
		 }*/
		
	}
	
	

}
