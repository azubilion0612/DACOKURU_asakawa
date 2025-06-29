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
        Department department = new Department();
        department.setNameJp(nameJp);
        department.setNameEn(nameEn);
        departmentRepository.save(department);
    }

	@Override
    public List<Department> departmentList() {
        return departmentRepository.findAll();
    }

	@Override
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("部署が見つかりませんでした"));
    }

	@Override
    public void updateDepartment(Long id, String nameJp, String nameEn) {
        Department department = findDepartmentById(id);
        department.setNameJp(nameJp);
        department.setNameEn(nameEn);
        departmentRepository.save(department);
    }

	@Override
    public List<Department> departmentList(String searchName) {
        return departmentRepository.findByNameJpContainingIgnoreCase(searchName);
    }

	@Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
