package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.MaintenanceCurative;

public interface MaintenanceCurRepository extends MongoRepository<MaintenanceCurative, String> {
	List<MaintenanceCurative> findByInventaireContaining(String inventaire);
}
