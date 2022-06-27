package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Inventaire;

public interface IventaireRepository extends MongoRepository<Inventaire, String> {
	List<Inventaire> findByReferenceContaining(String reference);

}
