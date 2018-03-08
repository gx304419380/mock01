package com.fly.dao;

import com.fly.dao.impl.UserDaoImpl;
import com.fly.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author XXX
 * @since 2018-03-07
 */
public class UserDaoTest {

    private UserDao userDao;
    private User u1;
    private User u2;

    @Before
    public void init() {
        userDao = Mockito.mock(UserDaoImpl.class);
        u1 = new User(1, "张三", 15);
        u2 = new User(2, "李四", 18);
        Mockito.when(userDao.getUserById(1)).thenReturn(u1);
        Mockito.when(userDao.getUserById(2)).thenReturn(u2);
        Mockito.when(userDao.getUserByName("张三")).thenReturn(u1);
        Mockito.when(userDao.getUserByName("李四")).thenReturn(u2);
        Mockito.when(userDao.getUserByAge(15)).thenReturn(u1);
        Mockito.when(userDao.getUserByAge(18)).thenReturn(u2);
        Mockito.when(userDao.getUserById(1000)).thenThrow(new RuntimeException("id 过于大！"));
    }

    @Test
    public void getUserById() throws Exception {
        User user = userDao.getUserById(1);
        System.out.println(user);
        Assert.assertEquals(user, u1);
        user = userDao.getUserById(2);
        System.out.println(user);
        Assert.assertEquals(user, u2);
    }

    @Test
    public void getUserByName() throws Exception {
        System.out.println(userDao.getUserByName("张三"));
    }

    @Test
    public void getUserByAge() throws Exception {
        User user = userDao.getUserByAge(18);
        System.out.println(user);
    }

    @Test
    public void getUserByIdWithException() {
        userDao.getUserById(1000);
    }

}