package com.companyname.devops.sampledeployment.controller;

import com.companyname.devops.sampledeployment.dto.UserDTO;
import com.companyname.devops.sampledeployment.entity.User;
import com.companyname.devops.sampledeployment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SimpleController {
    private final UserService service;

    @GetMapping("/test")
    String test() {
        return "service is working";
    }

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> userOpt = service.findById(id);
        return userOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {
        User user = service.save(userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/all")
    ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
