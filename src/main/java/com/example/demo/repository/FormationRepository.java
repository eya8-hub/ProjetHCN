package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Formation;

public interface FormationRepository extends MongoRepository<Formation, String> {
	List<Formation> findByTitreContaining(String title);
	  List<Formation> findByRealise(boolean realise);

}
