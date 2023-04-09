package com.qwetzal.blogr.authservice.service;

import com.qwetzal.blogr.authservice.model.User;
import com.qwetzal.blogr.authservice.repository.UsersRepository;
import com.qwetzal.blogr.authservice.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl  implements UserService{

    private final UsersRepository usersRepository;
    @Override
    public List<User> GetAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User AddUser(UserRequest user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        return usersRepository.save(newUser);
    }
}
