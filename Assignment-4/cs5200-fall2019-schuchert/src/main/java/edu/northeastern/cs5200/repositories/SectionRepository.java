package edu.northeastern.cs5200.repositories;


import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Section;

public interface SectionRepository extends CrudRepository<Section, Integer>{

}
