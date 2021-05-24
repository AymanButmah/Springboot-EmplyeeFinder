package edu.bethlehem.SpringBootWebProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class departments {


	@Column(name = "dept_name")
	String deptName;
	@Id
	String dept_no;

	public departments() {
	}

	// Parameterized constructor
	public departments(String dept_name, String dept_no) {
		this.deptName = dept_name;
		this.dept_no = dept_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDept_name(String dept_name) {
		this.deptName = dept_name;
	}
}
