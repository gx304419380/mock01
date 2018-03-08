package com.fly.dao;

import com.fly.entity.User;

/**
 * @author XXX
 * @since 2018-03-07
 */
public interface UserDao {
    User getUserById(Integer id);
    User getUserByName(String name);
    User getUserByAge(Integer age);
}
