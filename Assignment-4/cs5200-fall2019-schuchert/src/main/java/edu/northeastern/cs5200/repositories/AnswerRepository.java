package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer,Integer> {

}
