package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class DepartmentRepositoryImpl implements DepartmentRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void createDepartment(String nameJp, String nameEn) {
		String sql = """
				INSERT INTO
				  departments (name_jp, name_en)
				VALUES
				  (?, ?)
				""";
		jdbcTemplate.update(sql, nameJp, nameEn);

	}
	
	@Override
	public List<Department> departmentList(){
		String sql = """
				SELECT
				    name_jp
				FROM
				    departments
				""";
		
		List<Map<String, Object>> list
		    = jdbcTemplate.queryForList(sql);
		
		List<Department> result = new ArrayList<Department>();
		for(Map<String, Object> one : list) {
			Department department = new Department();
		department.setId((Long) one.get("id"));
		department.setNameJp((String) one.get("name_jp"));
		
		        result.add(department);
		}
		
		return result;
	}

}
