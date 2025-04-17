package com.example.demo.repository;

import com.example.demo.model.Kit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KitRepository extends MongoRepository<Kit, String> {
    
    List<Kit> findByUserId(String userId);  // Find all kits by user ID
    
    List<Kit> findByAdminId(String adminId); // Find all kits by admin ID
    
    Optional<Kit> findById(String id); // Ensure findById is available
}
