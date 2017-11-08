package com.tecsup.SpringMVC.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.SpringMVC.model.Department;

public class DepartmentMapper implements RowMapper<Department>{

	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dpto = new Department();
		dpto.setDepartmentId(rs.getInt("department_id"));
		dpto.setName(rs.getString("name"));
		dpto.setDesc(rs.getString("description"));
		dpto.setCity(rs.getString("city"));
		return dpto;
	}
}
