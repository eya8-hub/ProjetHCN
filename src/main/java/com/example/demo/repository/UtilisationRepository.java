package com.example.demo.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Utilisation;

public interface UtilisationRepository extends MongoRepository<Utilisation, String> {
	List<Utilisation> findByEmplacementContaining(String emplacement);

}
