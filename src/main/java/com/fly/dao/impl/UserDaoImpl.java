package com.fly.dao.impl;

import com.fly.dao.UserDao;
import com.fly.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author XXX
 * @since 2018-03-07
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public User getUserById(Integer id) {
        return null;
    }

    public User getUserByName(String name) {
        return null;
    }

    public User getUserByAge(Integer age) {
        return null;
    }
}
