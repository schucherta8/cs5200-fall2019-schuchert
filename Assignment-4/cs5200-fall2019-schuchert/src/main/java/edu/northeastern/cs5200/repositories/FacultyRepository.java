package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

}
