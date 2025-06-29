package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {
	
	void createDepartment(String nameJp, String nameEn);
	
	public List<Department> departmentList();
	
	public Department findDepartmentById(Long departmentId);
	
	void updateDepartment(Long departmentId, String updateNameJp, String updateNameEn);
	
	public List<Department> departmentList(String searchDepartment);
	
	void deleteDepartment(Long departmentId);

}
