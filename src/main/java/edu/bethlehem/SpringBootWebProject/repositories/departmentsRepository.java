package edu.bethlehem.SpringBootWebProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.bethlehem.SpringBootWebProject.models.departments;


public interface departmentsRepository extends CrudRepository<departments, Integer> {
	List<departments> findAll();

	List<departments> findByDeptNameLike(String deptName);

}
