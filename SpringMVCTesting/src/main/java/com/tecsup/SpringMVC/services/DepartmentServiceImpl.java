package com.tecsup.SpringMVC.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tecsup.SpringMVC.dao.DepartmentDAO;
import com.tecsup.SpringMVC.dao.jdbc.DepartmentDAOImpl;
import com.tecsup.SpringMVC.exception.DAOException;
import com.tecsup.SpringMVC.exception.EmptyResultException;
import com.tecsup.SpringMVC.mapper.DepartmentMapper;
import com.tecsup.SpringMVC.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public Department find(int department_id) throws DAOException, EmptyResultException {
		
		Department dpto = departmentDAO.findDepartment(department_id);

		return dpto;
	}

	@Override
	public List<Department> findAll()
			throws DAOException, EmptyResultException {
		
		List<Department> dptos = departmentDAO.findAllDepartment();
	
		return dptos;
	}

	@Override
	public void update(String name, String desc, String city)
			throws DAOException {
	
		departmentDAO.update(name, desc, city);
	}

	@Override
	public void delete(String name) throws DAOException {
		 
		departmentDAO.delete(name);
	
	}

	@Override
	public void create(String name, String desc, String city)
			throws DAOException {
	
		departmentDAO.create(name, desc, city);

	}
	
	

}


