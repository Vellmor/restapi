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
    public User readLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public User readLoginPassword(String login, String password) {
        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Override
    public boolean update(User user, String login) {
        if (userRepository.existsByLogin(login)) {
            long id = userRepository.getUserByLogin(login).getId();
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

    @Override
    public boolean delete(String login) {
        if (userRepository.existsByLogin(login)) {
            long id = userRepository.getUserByLogin(login).getId();
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
