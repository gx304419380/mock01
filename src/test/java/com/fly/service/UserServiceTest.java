package com.fly.service;

import com.fly.dao.UserDao;
import com.fly.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author XXX
 * @since 2018-03-07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class UserServiceTest {

    // 这个注解会使得该Bean从mock中拿到相应的userDao
    @InjectMocks
    @Autowired
    private UserService userService;
    @Mock
    private UserDao userDao;

    private User u1;
    private User u2;

    @Before
    public void init() throws BeansException {

        MockitoAnnotations.initMocks(this);

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
        System.out.println(userService.getUserById(1));
    }

    @Test
    public void getUserByName() throws Exception {
        System.out.println(userService.getUserByName("张三"));
    }

    @Test
    public void getUserByAge() throws Exception {
        System.out.println( userService.getUserByAge(18));
    }

}