package com.example.demo.repository;

import com.example.demo.model.KitAssignment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.KitStatus;

public interface KitAssignmentRepository extends MongoRepository<KitAssignment, String> {
    List<KitAssignment> findByStatus(KitStatus status);
    List<KitAssignment> findAll();
}

