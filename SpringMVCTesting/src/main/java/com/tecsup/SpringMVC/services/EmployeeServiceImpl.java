package com.tecsup.SpringMVC.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tecsup.SpringMVC.dao.EmployeeDAO;
import com.tecsup.SpringMVC.dao.jdbc.EmployeeDAOImpl;
import com.tecsup.SpringMVC.exception.DAOException;
import com.tecsup.SpringMVC.exception.EmptyResultException;
import com.tecsup.SpringMVC.mapper.EmployeeMapper;
import com.tecsup.SpringMVC.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public List<Employee> findAll() throws DAOException, EmptyResultException {

		List<Employee> emps = employeeDAO.findAllEmployees();
		
		return emps;
	}
	
	@Override
	public void update(String login, String password, String lastname, String firstname, long salary, int dptId)
			throws DAOException {
	
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);
	}


}
