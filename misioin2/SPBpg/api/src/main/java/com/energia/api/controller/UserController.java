package com.energia.api.controller;
import com.energia.api.model.User;
import com.energia.api.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
      return userRepository.save(user);
  }
  
  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User user) {
    User existing = userRepository.findById(id).orElseThrow();
    existing.setUsername(user.getUsername());
    existing.setEmail(user.getEmail());
    return userRepository.save(existing);
  }
  
  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}
