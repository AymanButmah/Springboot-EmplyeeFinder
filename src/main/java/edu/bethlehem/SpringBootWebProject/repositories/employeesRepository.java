package edu.bethlehem.SpringBootWebProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.bethlehem.SpringBootWebProject.models.employees;

@Repository
public interface employeesRepository extends CrudRepository<employees, Integer> {
	List<employees> findAll();

	List<employees> findByLastNameOrFirstName(String empLName, String empFName);

	List<employees> findById(int emp_no);
}
