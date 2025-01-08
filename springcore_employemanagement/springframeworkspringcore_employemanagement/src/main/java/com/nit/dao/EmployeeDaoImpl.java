package com.nit.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nit.model.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	private String GET_ALL = "select * from employee";
	private String INSERT = "insert into employee(name,address,salary) values (?,?,?);";
	private String DELETE = "delete from employee where id=?";
	private String GET_ONE = "select * from employee where id=?";
	private String UPDATE = "update employee set name=?, address=?, salary=? where id=?";

	private RowMapper<Employee> rowMapper;

	public void setRowMapper(RowMapper<Employee> rowMapper) {
		this.rowMapper = rowMapper;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return getJdbcTemplate().query(GET_ALL, rowMapper);
	}

	@Override
	public void saveEmpoloyee(Employee emp) {
		getJdbcTemplate().update(INSERT, emp.getName(), emp.getAddress(), emp.getSalary());

	}

	@Override
	public void deleteEmployee(Integer id) {
		getJdbcTemplate().update(DELETE, id);

	}

	@Override
	public Employee getEmployee(Integer id) {
		List<Employee> employees = getJdbcTemplate().query(GET_ONE, rowMapper,id);
		return employees.get(0);
	}

	@Override
	public void updateEmpoloyee(Employee emp) {
		 getJdbcTemplate().update(UPDATE, emp.getName(),emp.getAddress(),emp.getSalary(),emp.getId());
	}

}
