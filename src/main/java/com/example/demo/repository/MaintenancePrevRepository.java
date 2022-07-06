package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.MaintenancePreventive;

public interface MaintenancePrevRepository  extends MongoRepository<MaintenancePreventive, String>{
	List<MaintenancePreventive> findByInventaireContaining(String inventaire);
}
