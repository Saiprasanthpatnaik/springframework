package com.nit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.dao.EmployeeDao;
import com.nit.model.Employee;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/getAllEmployees")
	public String getAllEmployees(Model model){
		List<Employee> emps = employeeDao.getAllEmployees();
		model.addAttribute("emps", emps);
		return "show_employees";
	}
	
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee emp){
		employeeDao.saveEmpoloyee(emp);
		return "redirect:/getAllEmployees";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee emp){
		employeeDao.updateEmpoloyee(emp);
		return "redirect:/getAllEmployees";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Model model){	
		Employee emp = new Employee();
		model.addAttribute("emp",emp);
		return "add_employee";
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(HttpServletRequest request){	
		String id = request.getParameter("emp_id");
		employeeDao.deleteEmployee(Integer.valueOf(id));
		return "redirect:/getAllEmployees";
	}
	
	
	@RequestMapping("/editEmployee")
	public String editEmployee(HttpServletRequest request, Model model){	
		String id = request.getParameter("emp_id");
		Employee emp = employeeDao.getEmployee(Integer.valueOf(id));
		model.addAttribute("emp", emp);
		return "update_employee";
	}
	
	
	
	
	
	
	
	
	
	
	
}
