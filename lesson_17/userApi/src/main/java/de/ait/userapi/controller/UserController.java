package de.ait.userapi.controller;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        try {
            return ResponseEntity.ok(service.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto>getById(@PathVariable(name = "id") Long userId){

        try {
            return ResponseEntity.ok(service.getUserById(userId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto dto){
        try {
            return ResponseEntity.status(201).body(service.addUser(dto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
