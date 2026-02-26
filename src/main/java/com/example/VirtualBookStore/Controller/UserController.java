package com.example.VirtualBookStore.Controller;

import com.example.VirtualBookStore.DTO.UserDTO;
import com.example.VirtualBookStore.Entity.User;
import com.example.VirtualBookStore.Service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("All users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }




}
