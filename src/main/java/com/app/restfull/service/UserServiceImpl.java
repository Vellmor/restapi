package com.app.restfull.service;

import com.app.restfull.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService{

    private static final Map<Long, User> USER_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    public UserServiceImpl() {
    }

    @Override
    public void create(User user) {
        final long userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        USER_REPOSITORY_MAP.put(userId, user);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(USER_REPOSITORY_MAP.values());
    }

    @Override
    public User read(long id) {
        return USER_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(User user, long id) {
        if (USER_REPOSITORY_MAP.containsKey(id)) {
            user.setId(id);
            USER_REPOSITORY_MAP.put(id, user);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        return USER_REPOSITORY_MAP.remove(id) != null;
    }
}
