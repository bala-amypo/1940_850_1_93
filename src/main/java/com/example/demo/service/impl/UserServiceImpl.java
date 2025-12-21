package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        if (user.getRole() == null) user.setRole("USER");
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));
    }
    
    public User createUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty())
            throw new ValidationException("Name is required");
        if (user.getEmail() == null || user.getEmail().trim().isEmpty())
            throw new ValidationException("Email is required");
        if (repo.findByEmail(user.getEmail()).isPresent())
            throw new ValidationException("Email already exists");
        return register(user);
    }
    
    public List<User> getAllUsers() {
        return repo.findAll();
    }
    
    public User getUserById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }
    
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        if (user.getName() != null && !user.getName().trim().isEmpty()) {
            existing.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            if (!existing.getEmail().equals(user.getEmail()) && 
                repo.findByEmail(user.getEmail()).isPresent()) {
                throw new ValidationException("Email already exists");
            }
            existing.setEmail(user.getEmail());
        }
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            existing.setPassword(user.getPassword());
        }
        if (user.getRole() != null) existing.setRole(user.getRole());
        return repo.save(existing);
    }
    
    public void deleteUser(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("User not found: " + id);
        repo.deleteById(id);
    }
}
