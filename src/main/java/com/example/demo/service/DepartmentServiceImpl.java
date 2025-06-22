package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	@Override
	public void createDepartment(String nameJp, String nameEn) {
		departmentRepository.createDepartment(nameJp, nameEn);
	}
	
	@Override
	public List<Department> departmentList(){
		List<Department> list = departmentRepository.departmentList();
		return list;
	}
	
	@Override
	public Department findDepartmentById(Long departmentId) {
		return departmentRepository.findDepartmentById(departmentId);
	}
	
	@Override
	public void updateDepartment(Long departmentId, String updateNameJp, String updateNameEn) {
        departmentRepository.updateDepartment(departmentId, updateNameJp, updateNameEn);
	}
	
	@Override
	public List<Department> departmentList(String searchDepartment){
		List<Department> list = departmentRepository.departmentList(searchDepartment);
		return list;
	}
	
	@Override
	public void deleteDepartment(Long departmentId) {
		departmentRepository.deleteDepartment(departmentId);
	}

}
