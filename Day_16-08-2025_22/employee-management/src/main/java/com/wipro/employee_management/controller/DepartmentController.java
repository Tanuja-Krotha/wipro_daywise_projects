package com.wipro.employee_management.controller;

import com.wipro.employee_management.entity.Department;
import com.wipro.employee_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Show list of departments
    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "department-list"; // department-list.html
    }

    // Show add department form
    @GetMapping("/add")
    public String showAddDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "add-department"; // add-department.html
    }

    // Save department
    @PostMapping("/add")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    // Show edit department form
    @GetMapping("/edit/{id}")
    public String showEditDepartmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "edit-department"; // edit-department.html
    }

    // Update department
    @PostMapping("/edit/{id}")
    public String updateDepartment(@PathVariable Long id, @ModelAttribute("department") Department department) {
        department.setId(id);
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    // Delete department
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
}
