package com.qwetzal.blogr.authservice.service;

import com.qwetzal.blogr.authservice.model.User;
import com.qwetzal.blogr.authservice.requests.UserRequest;

import java.util.List;

public interface UserService {

    List<User> GetAllUsers();

    User AddUser(UserRequest user);
}
