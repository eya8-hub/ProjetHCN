package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Fournisseur;


public interface FournisseurRepository extends MongoRepository<Fournisseur, String> {
	List<Fournisseur> findByFabriquantContaining(String fabriquant);

}
