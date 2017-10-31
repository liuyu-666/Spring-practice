package com.kaisheng.service;

import com.kaisheng.dao.UserDao;
import com.kaisheng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuyu
 * @date 2017/10/31
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public  void save(User user) {

        userDao.save(user);
//        if(true) {
//            throw new RuntimeException();
//        }
        userDao.save(user);

    }

}
