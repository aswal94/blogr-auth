package com.qwetzal.blogr.authservice.service;

import com.qwetzal.blogr.authservice.model.User;
import com.qwetzal.blogr.authservice.repository.UsersRepository;
import com.qwetzal.blogr.authservice.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final UsersRepository userRepository;

    @Override
    public Optional<User> AddUser(UserRequest user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles("ROLE_USER");
        return Optional.of(userRepository.save(newUser));
    }
}
