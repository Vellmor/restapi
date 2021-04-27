package com.app.restfull.service;

import com.app.restfull.model.User;
import com.app.restfull.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
        logger.info("User {1} created", user.getLogin());
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
            logger.info("User {1} updated", user.getLogin());
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            logger.info("User with id = {1} deleted", id);
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
