package com.qwetzal.blogr.authservice.service;

import com.qwetzal.blogr.authservice.model.User;
import com.qwetzal.blogr.authservice.requests.UserRequest;

import java.util.Optional;

public interface AuthService {
    public Optional<User> AddUser(UserRequest user);
}
