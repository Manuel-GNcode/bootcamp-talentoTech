package com.energia.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.energia.api.dto.LoginRequest;
import com.energia.api.model.User;
import com.energia.api.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    return userRepository.findById(id)
    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado"));
  }

  public User updateUser(Long id, User user) {
    User existing = userRepository.findById(id)
    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));

    if (user.getUsername() != null && !user.getUsername().isBlank()) {
      existing.setUsername(user.getUsername());
    }
    if (user.getEmail() != null && !user.getEmail().isBlank()) {
      existing.setEmail(user.getEmail());
    }
    if (user.getPassword() != null && !user.getPassword().isBlank()) {
      existing.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    if (user.getRole() != null) {
      existing.setRole(user.getRole());
    }
    return userRepository.save(existing);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  public String login(LoginRequest request) {
    Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());
    if (optionalUser.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
    }
    User user = optionalUser.get();
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
    }
    return "Login correcto";
  }
}
