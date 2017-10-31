package com.kaisheng.dao;

import com.kaisheng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuyu
 * @date 2017/10/26
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user){
        String sql = "insert into t_user (name,address) values (?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAddress());
    }
    public void update(User user) {
        String sql = "update t_user set name=?,address=? where id=?";
        jdbcTemplate.update(sql,user.getName(),user.getAddress(),user.getId());
    }

    public List<User> findAll() {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
    public User findById(int id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }
}
