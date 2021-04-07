package com.app.restfull.service;

import com.app.restfull.model.User;
import com.app.restfull.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean update(User user, long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
