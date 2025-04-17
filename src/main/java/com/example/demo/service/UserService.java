package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.KitRepository; // ✅ Import missing KitRepository
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final KitRepository kitRepository; // ✅ Inject KitRepository
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerUser(RegisterRequest request) {
        if (userRepository.findByPhone(request.getPhoneNumber()).isPresent()) {
            return ResponseEntity.badRequest().body("Phone number already registered.");
        }

        // Use Builder pattern for better maintainability
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .aadhaarNumber(request.getAadhaarNumber())
                .email(request.getEmail())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .landmark(request.getLandmark())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // ✅ Ensure trackKit() has access to kitRepository
    /*public ResponseEntity<?> trackKit(String kitId) {
        return kitRepository.findById(kitId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("Kit not found!"));
    }*/
}
