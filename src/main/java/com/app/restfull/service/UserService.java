package com.app.restfull.service;

import com.app.restfull.model.User;

import java.util.List;

public interface UserService {
    /**
     * Создает нового пользователя
     * @param user - клиент для создания
     */
    void create(User user);

    /**
     * Возвращает список всех имеющихся пользователей
     * @return список пользователей
     */
    List<User> readAll();

    /**
     * Возвращает пользователя по его login
     * @param login - login пользователя
     * @return - объект пользователя с заданным login
     */
    User readLogin(String login);

    /**
     * Возвращает пользователя по его login
     * @param login - login пользователя
     * @param password - пароль пользователя
     * @return - объект пользователя с заданным login и паролем
     */
    User readLoginPassword(String login, String password);

    /**
     * Обновляет пользователя с заданным ID,
     * в соответствии с переданным пользователем
     * @param user - пользователь в соответсвии с которым нужно обновить данные
     * @param login - login пользователя которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(User user, String login);

    /**
     * Удаляет пользователя с заданным ID
     * @param login - lpgin пользователя, которого нужно удалить
     * @return - true если пользователь был удален, иначе false
     */
    boolean delete(String login);


}
