package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Inventaire;
import com.example.demo.model.Métrologie;


public interface MetrologieRepository extends MongoRepository<Métrologie, String> {
	List<Métrologie> findByInventaireContaining(Inventaire inventaire);
}
