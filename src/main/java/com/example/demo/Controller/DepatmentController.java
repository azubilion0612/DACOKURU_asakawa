package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Department;
import com.example.demo.form.DepartmentForm;
import com.example.demo.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class DepatmentController {

	private final DepartmentService departmentService;
		
	@GetMapping("/department/index")
	public String departmentList(Model model) {
			List<Department> list = departmentService.departmentList();
			model.addAttribute("departmentList",list);
		
	    return "department/index";
	}
	
    @GetMapping("/department/create")
    public String create() {
    
    	return "department/create";
    }
    
    @PostMapping("/department/store")
    public String createDeprtment(@ModelAttribute DepartmentForm departmentForm, Model model) {
    	    departmentService.createDepartment(
    	    departmentForm.getNameJp(),
            departmentForm.getNameEn()
    	    );
            return "redirect:/department/index";
    }
    
}
