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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody Map<String, String> user) {
        return ResponseEntity.ok(weavyService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(weavyService.deleteUser(id));
    }
}
