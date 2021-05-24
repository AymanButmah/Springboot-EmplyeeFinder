package edu.bethlehem.SpringBootWebProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employees {

	@Id
	int emp_no;

	String birth_date;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;

	String gender;

	String hire_date;

	public employees() {
	}

	public employees(int emp_no, String birth_date, String first_name, String last_name, String gender,
			String hire_date) {
		this.emp_no = emp_no;
		this.birth_date = birth_date;
		this.firstName = first_name;
		this.lastName = last_name;
		this.gender = gender;
		this.hire_date = hire_date;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

}