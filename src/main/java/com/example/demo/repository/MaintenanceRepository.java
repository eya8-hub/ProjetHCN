package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Maintenance;


public interface MaintenanceRepository extends MongoRepository<Maintenance, String> {
	List<Maintenance> findByInventaireContaining(String Inventaire);
}
