package com.app.restfull.repository;

import com.app.restfull.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
    User getUserByLoginAndPassword(String login, String password);
    Boolean existsByLogin(String login);
}
