package com.nit.dao;

import java.util.List;


import com.nit.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	void saveEmpoloyee(Employee emp);
	void deleteEmployee(Integer id);
	Employee getEmployee(Integer id);
	void updateEmpoloyee(Employee emp);
}
