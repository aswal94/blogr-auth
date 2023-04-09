package com.qwetzal.blogr.authservice.controller;

import com.qwetzal.blogr.authservice.model.User;
import com.qwetzal.blogr.authservice.requests.UserRequest;
import com.qwetzal.blogr.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public List<User> GetUsers(){
        return userService.GetAllUsers();
    }

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public User GetUsers(@RequestBody UserRequest user){
        return userService.AddUser(user);
    }
}
