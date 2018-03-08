package com.fly.service;

import com.fly.entity.User;

/**
 * @author XXX
 * @since 2018-03-07
 */
public interface UserService {
    User getUserById(Integer id);
    User getUserByName(String name);
    User getUserByAge(Integer age);
}
