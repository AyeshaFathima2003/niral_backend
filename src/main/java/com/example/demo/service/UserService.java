package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Kit;
import com.example.demo.model.KitAssignment;
import com.example.demo.model.KitStatus;
import com.example.demo.model.User;
import com.example.demo.repository.KitAssignmentRepository;
import com.example.demo.repository.KitRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KitAssignmentRepository kitAssignmentRepository;

    @Autowired
    private KitRepository kitRepository;  // Add this

    public User addUser(UserDTO userDTO, String adminId) {
        // Create and save user
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(userDTO.getName())
                .mobileNumber(userDTO.getMobileNumber())
                .emailId(userDTO.getEmailId())
                .aadharCard(userDTO.getAadharCard())
                .address(userDTO.getAddress())
                .district(userDTO.getDistrict())
                .purpose(userDTO.getPurpose())
                .startDate(userDTO.getStartDate())
                .endDate(userDTO.getEndDate())
                .location(userDTO.getLocation())
                .registeredBy(adminId)
                .build();

        User savedUser = userRepository.save(user);

        // Determine kit name based on purpose
        String selectedKitName = switch (userDTO.getPurpose().toLowerCase()) {
            case "agriculture" -> "Agriculture Borewell Kit";
            case "domestic" -> "Domestic Borewell Kit";
            case "industry" -> "Industrial Borewell Kit";
            default -> null;
        };

        String kitId = null;

        if (selectedKitName != null) {
            Kit kit = kitRepository.findByKitName(selectedKitName);
            if (kit != null) {
                kitId = kit.getKitId();
            }
        }

        // Create kit assignment
        KitAssignment assignment = KitAssignment.builder()
                .userName(savedUser.getName()) 
                .kitId(kitId) // now assigned based on purpose
                .status(KitStatus.REQUESTED)
                .requestDate(LocalDate.now())
                .build();

        kitAssignmentRepository.save(assignment);

        return savedUser;
    }
}


