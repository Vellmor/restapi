package com.app.restfull.service;

import com.app.restfull.model.User;
import com.app.restfull.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();

        User ivan = new User("ivan", passwordEncoder.encode("ivan123"));
        User admin = new User("admin", passwordEncoder.encode("admin123"));
        User manager = new User("manager", passwordEncoder.encode("man123"));

        List<User> users = Arrays.asList(ivan,admin,manager);

        this.userRepository.saveAll(users);
    }
}
