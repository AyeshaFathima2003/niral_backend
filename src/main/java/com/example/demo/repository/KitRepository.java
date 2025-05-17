package com.example.demo.repository;

import com.example.demo.model.Kit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KitRepository extends MongoRepository<Kit, String> {
    Kit findByKitName(String kitName);
    
}
