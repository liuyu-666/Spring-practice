package com.kaisheng.dao;

import com.kaisheng.Application;
import com.kaisheng.entity.User;
import com.kaisheng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuyu
 * @date 2017/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class UserDaoTestCase {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService service;

    @Test
    public void update(){
        User user = new User();
        user.setName("ly");
        user.setId(2);
        user.setAddress("jz");
        userDao.update(user);
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("axl");
        user.setAddress("ch");
        service.save(user);
    }
    @Test
    public void findAll(){
        List<User> userList = userDao.findAll();
      for(User user : userList) {
          System.out.println(user.getName());
      }
    }
    @Test
    public void findById() {
        User user = userDao.findById(2);
        System.out.println(user.getName());
    }
}
