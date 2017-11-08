package com.tecsup.SpringMVC.dao;

import java.util.List;

import com.tecsup.SpringMVC.exception.DAOException;
import com.tecsup.SpringMVC.exception.EmptyResultException;
import com.tecsup.SpringMVC.exception.LoginException;
import com.tecsup.SpringMVC.model.Department;

public interface DepartmentDAO {

	Department findDepartment(int id) throws DAOException, EmptyResultException;

	void create(String name, String desc, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String desc, String city) throws DAOException;

//	Department findEmployeeByLogin(String name) throws DAOException, EmptyResultException;

	List<Department> findAllDepartment() throws DAOException, EmptyResultException;

	List<Department> findDepartmentByName(String name) throws DAOException, EmptyResultException;

//	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
