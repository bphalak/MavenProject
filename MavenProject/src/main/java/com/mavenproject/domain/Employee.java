package com.mavenproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_employee")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="empno")
	private Long empno;
	
	@Column(name="empname")
	private String empname;
	
	@Column(name="empphone")
	private String empphone;
	
	@Column(name="empmail")
	private String empmail;
	
	@Column(name="enabled")
	private Boolean isEnabled;

	/**
	 * @return the empno
	 */
	public Long getEmpno() {
		return empno;
	}

	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(Long empno) {
		this.empno = empno;
	}

	/**
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	/**
	 * @return the empphone
	 */
	public String getEmpphone() {
		return empphone;
	}

	/**
	 * @param empphone the empphone to set
	 */
	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}

	/**
	 * @return the empmail
	 */
	public String getEmpmail() {
		return empmail;
	}

	/**
	 * @param empmail the empmail to set
	 */
	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}

	/**
	 * @return the isEnabled
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}