package com.example.user.controller;

import com.example.user.service.Weavy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class User {
    @Autowired
    private Weavy weavyService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> user) {
        return ResponseEntity.ok(weavyService.createUser(user));
    }
}
