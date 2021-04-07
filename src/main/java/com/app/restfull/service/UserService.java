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
     * Возвращает пользователя по его ID
     * @param id - ID пользователя
     * @return - объект пользователя с заданным ID
     */
    User read(long id);

    /**
     * Обновляет пользователя с заданным ID,
     * в соответствии с переданным пользователем
     * @param user - пользователь в соответсвии с которым нужно обновить данные
     * @param id - id пользователя которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(User user, long id);

    /**
     * Удаляет пользователя с заданным ID
     * @param id - id пользователя, которого нужно удалить
     * @return - true если пользователь был удален, иначе false
     */
    boolean delete(long id);


}
