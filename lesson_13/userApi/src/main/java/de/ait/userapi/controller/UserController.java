package de.ait.userapi.controller;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserDB;
import de.ait.userapi.repository.UserRepository;
import de.ait.userapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getById(@PathVariable(name = "id") Long userId){
        return service.getUserById(userId);
        //return repository.findAll().stream().filter(u->u.getName().equals(userId)).findFirst().get();
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto user){
        return service.addUser(user);

    }



}
