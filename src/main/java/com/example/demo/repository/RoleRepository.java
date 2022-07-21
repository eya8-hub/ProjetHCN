package com.example.demo.repository;
import com.example.demo.model.Role;
import com.example.demo.model.ERole;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
	 Optional<Role> findByName(ERole name);

}
