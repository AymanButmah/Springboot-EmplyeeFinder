package edu.bethlehem.SpringBootWebProject.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.bethlehem.SpringBootWebProject.models.employees;
import edu.bethlehem.SpringBootWebProject.repositories.employeesRepository;

@Controller
public class employeesController {
	@Autowired
	private employeesRepository repo;

	// Home Page
	@RequestMapping("/")
	public static String welcome() {
		return "index";
	}

	@GetMapping("/emps")
	public List<employees> getAllEmps() {
		return repo.findAll();
	}

	@RequestMapping("/employees")
	public String getAllEmployees(Model model, @RequestParam("quantity") int q) {
		List<employees> list = getAllEmps();
		List<employees> emps = new ArrayList<employees>(list.subList(0, q));
		model.addAttribute("employees", emps);
		return "employees-list";
	}

	@RequestMapping("/employees/newEmployee")
	public String insertAnEmployee(Model model, @RequestParam("emp_no_insert") int eNum,
			@RequestParam("bDate_insert") String bDate, @RequestParam("fName_insert") String fName,
			@RequestParam("lName_insert") String lName, @RequestParam("gender_insert") String gender,
			@RequestParam("hDate_insert") String hDate) {
		employees employee = new employees(eNum, bDate, fName, lName, gender, hDate);
		repo.save(employee);
		model.addAttribute("employees", employee);
		return "employees-list";
	}

	@RequestMapping("/employees/employee")
	public String searchEmployee(Model model, @RequestParam("emp_name_search") String eName) {
		List<employees> list = repo.findByLastNameOrFirstName(eName, eName);
		model.addAttribute("employees", list);
		return "employees-list";
	}

	@RequestMapping("/employees/delete")
	public String searchEmployee(Model model, @RequestParam("emp_no_del") int eNum) {
		List<employees> employee = repo.findById(eNum);
		repo.deleteById(eNum);
		model.addAttribute("employees", employee);
		return "delete-employee";
	}
}
