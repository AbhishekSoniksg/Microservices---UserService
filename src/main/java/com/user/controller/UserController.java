package com.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}