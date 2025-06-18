package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentRepository {
	
	void createDepartment(String nameJp, String nameEn);
	
	List<Department> departmentList();
	
	Department findDepartmentById(Long departmentId);
	
	void updateDepartment(Long departmentId, String updateNameJp, String updateNameEn);
}
