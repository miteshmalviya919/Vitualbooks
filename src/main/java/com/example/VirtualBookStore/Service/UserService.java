package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.DTO.UserDTO;
import com.example.VirtualBookStore.Entity.User;
import com.example.VirtualBookStore.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public UserDTO createUser(UserDTO userDTO) {
        // Convert DTO → Entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        // Save entity
        User savedUser = userRepository.save(user);

        // Convert back to DTO
        return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }


    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }
}