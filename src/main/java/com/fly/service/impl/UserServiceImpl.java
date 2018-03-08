package com.fly.service.impl;

import com.fly.dao.UserDao;
import com.fly.dao.impl.UserDaoImpl;
import com.fly.entity.User;
import com.fly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XXX
 * @since 2018-03-07
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public User getUserByAge(Integer age) {
        return userDao.getUserByAge(age);
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
