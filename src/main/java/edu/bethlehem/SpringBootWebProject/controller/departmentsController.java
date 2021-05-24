package edu.bethlehem.SpringBootWebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.bethlehem.SpringBootWebProject.models.departments;
import edu.bethlehem.SpringBootWebProject.repositories.departmentsRepository;

@Controller
public class departmentsController {
	@Autowired
	private departmentsRepository repos;

	// Get All Notes
	@GetMapping("/depts")
	public List<departments> getAllDepts() {
		return repos.findAll();
	}

	@RequestMapping("/departments")
	public String getAllDepartments(Model model) {
		List<departments> list = getAllDepts();
		model.addAttribute("departments", list);
		return "departments-list";
	}

	@RequestMapping("/departments/newDepartment")
	public String insertDepartment(Model model, @RequestParam("dept_no_insert") String dNum,
			@RequestParam("dept_name_insert") String dName) {
		departments department = new departments(dName, dNum);
		repos.save(department);
		model.addAttribute("departments", department);
		return "departments-list";
	}

	@RequestMapping("/departments/department")
	public String searchDepartment(Model model, @RequestParam("dept_name_search") String dName) {
		List<departments> list = repos.findByDeptNameLike(dName);
		model.addAttribute("departments", list);
		return "departments-list";
	}

}
