package com.mavenproject.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dat_department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name="deptno")
	private Long deptno;
	
	@Column(name="depname")
	private String depname;
	
	@Column(name="deplocation")
	private String deplocation;
	
	@Column(name="createddate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createddate;
	
	@Column(name="enabled")
	private Boolean isEnabled;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Employee> emplist = new ArrayList<Employee>();

	/**
	 * @return the deptno
	 */
	public Long getDeptno() {
		return deptno;
	}

	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	/**
	 * @return the depname
	 */
	public String getDepname() {
		return depname;
	}

	/**
	 * @param depname the depname to set
	 */
	public void setDepname(String depname) {
		this.depname = depname;
	}

	/**
	 * @return the deplocation
	 */
	public String getDeplocation() {
		return deplocation;
	}

	/**
	 * @param deplocation the deplocation to set
	 */
	public void setDeplocation(String deplocation) {
		this.deplocation = deplocation;
	}

	/**
	 * @return the createddate
	 */
	public Date getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
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

	/**
	 * @return the emplist
	 */
	public List<Employee> getEmplist() {
		return emplist;
	}

	/**
	 * @param emplist the emplist to set
	 */
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
}