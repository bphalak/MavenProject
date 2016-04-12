package com.mavenproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.domain.Department;

public class DepartmentServiceBean {

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = Logger.getLogger(DepartmentServiceBean.class.getName());
	
	public DepartmentServiceBean(){
		
	}

	@Transactional
	public List<Department> searchDepartment(Department department) {
		
		List<Department> departmentList = new ArrayList<Department>();
		Session session = sessionFactory.getCurrentSession();
		
		try{
			
			//Search Department
			String hql = "FROM Department t";
			boolean coladd = false;
			
			if(department.getDeptno() != null && department.getDeptno() > 0){
				
				hql += (coladd)?" or":" where";
				hql += " t.deptno =:deptno";
				coladd = true;
			}
			if(department.getDepname() != null && department.getDepname().length() > 0){
				
				hql += (coladd)?" or":" where";
				hql += " t.depname =:depname";
				coladd = true;
			}
			
			Query query = session.createQuery(hql);
			
			if(department.getDeptno() != null && department.getDeptno() > 0){
				
				query.setParameter("deptno", department.getDeptno());
			}
			if(department.getDepname() != null && department.getDepname().length() > 0){
				
				query.setParameter("depname", department.getDepname());
			}
			
			System.out.println("query :" + query);
			departmentList = query.list();
			System.out.println("results :" + departmentList.size());
			log.info("Hi this is logger message");
			log.error("Hi this is logger message");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return departmentList;
	}
	
	@Transactional
	public Boolean addDepartment(Department department) {
		
		Session session = sessionFactory.getCurrentSession();
		Boolean sucess = false;
		
		try{
			
			department.setIsEnabled(true);
			department.setCreateddate(new Date());
			session.save(department);
			sucess = true;
			
		}catch(Exception e){
			sucess = false;
			e.printStackTrace();
		}
		
		return sucess;
	}
	
	@Transactional
	public Department getModifyDepartmentData(Long depid) {
		
		Session session = sessionFactory.getCurrentSession();
		Department department = new Department();
		
		try{
			
			try{
				//Search Department
				String hql = "FROM Department t where t.deptno =:deptno";
				Query query = session.createQuery(hql);
				query.setParameter("deptno", depid);
				
				department = (Department) query.uniqueResult();
			//	Hibernate.initialize(department);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return department;
	}
	
	/*
	 * Modify Department
	 */
	@Transactional
	public String addUpdateDepartmentData(Department department) {
		
		Session session = sessionFactory.getCurrentSession();
        String success = "SearchDepartment";
		try{
			
			//Update department data
			department.setCreateddate(new Date());
			
			session.update(department);
	 		
		}catch(Exception e){
			
			e.printStackTrace();
			success = "ModifyDepartment";
		}
		
		
		return success;
	}
	
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
