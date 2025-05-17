package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/add")
    public User addUser(@RequestHeader("Authorization") String token,
                        @RequestBody UserDTO userDTO) {

        String jwt = token.substring(7); // remove "Bearer "
        String adminEmail = jwtUtil.extractEmail(jwt);
        String adminId = adminEmail; // or fetch from DB if email ≠ adminId

        return userService.addUser(userDTO, adminId);
    }
}
