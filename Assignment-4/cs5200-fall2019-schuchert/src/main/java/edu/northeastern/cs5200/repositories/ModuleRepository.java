package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Module;

public interface ModuleRepository extends CrudRepository<Module,Integer>{

}
