package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}