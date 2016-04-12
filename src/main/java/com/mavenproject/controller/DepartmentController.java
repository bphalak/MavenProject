package com.mavenproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mavenproject.domain.Department;
import com.mavenproject.service.DepartmentServiceBean;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentServiceBean departmentServiceBean;
	
	@RequestMapping("/searchdept")
	public ModelAndView redirecrSearchDepartment(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
	//	ModelAndView mv = new ModelAndView("helloworld");
		ModelAndView mv = new ModelAndView("SearchDepartment");
	//	mv.addObject("message", message);
	//	mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping(value="/searchdepartment", method = RequestMethod.GET)
	public ModelAndView searchDepartment() {
		System.out.println("in controller");
 		
		ModelAndView mv = new ModelAndView("SearchDepartment");
		return mv;
	}
	
	@RequestMapping(value="/searchdepartment", method = RequestMethod.POST)
	public ModelAndView searchDepartment(@ModelAttribute Department department, ModelMap model,
			@RequestParam("action")String action, @RequestParam("depid")String depid) {
		
		System.out.println("getDepname :"+department.getDepname());
		System.out.println("action :"+action);
		ModelAndView mv = new ModelAndView();
		
		switch(action){
			
			case "Search":
				
				List<Department> departments = departmentServiceBean.searchDepartment(department);
				mv.setViewName("SearchDepartment");
				mv.addObject("deptList", departments);
			break;
			
			case "New Department":
				mv.setViewName("CreateDepartment");
			break;
			
			case "Modify":
						
				if(depid != null && !depid.isEmpty()){
				
					Department departmentData = departmentServiceBean.getModifyDepartmentData(Long.parseLong(depid));
					mv.setViewName("ModifyDepartment");
					mv.addObject("department", departmentData);
				}
				
			break;
			
			case "Delete":
				
				mv.setViewName("SearchDepartment");
			break;
			
			default:
				System.out.println("ACTION Not found :"+action);
			break;
		
		}
	
		return mv;
	}

	@RequestMapping(value="/adddepartment", method = RequestMethod.POST)
	public ModelAndView addDepartment(@ModelAttribute Department department, ModelMap model,
			@RequestParam("action")String action) {
		
		ModelAndView mv = new ModelAndView("CreateDepartment");
		
		if(departmentServiceBean.addDepartment(department)){
			mv.setViewName("SearchDepartment");
		}
		return mv;
	}
	
	@RequestMapping(value = "/modifydepartment", method = RequestMethod.POST)
	public ModelAndView modifyDepartment(@ModelAttribute Department department, ModelMap model,@RequestParam("action")String action) {

		System.out.println("modifyDepartment "+action);
		ModelAndView mv = new ModelAndView("SearchDepartment");
		
		switch(action){
		
			case "Save":
				mv.setViewName(departmentServiceBean.addUpdateDepartmentData(department));
				break;
				
			default :
				mv.setViewName("SearchDepartment");
				break;
		}

		return mv;
	}
	
	/**
	 * @return the departmentServiceBean
	 */
	public DepartmentServiceBean getDepartmentServiceBean() {
		return departmentServiceBean;
	}

	/**
	 * @param departmentServiceBean the departmentServiceBean to set
	 */
	public void setDepartmentServiceBean(DepartmentServiceBean departmentServiceBean) {
		this.departmentServiceBean = departmentServiceBean;
	}
	
	
	
}
