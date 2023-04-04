package com.example.webdb.Repository;

import com.example.webdb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUser(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM usertable WHERE id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update("INSERT INTO usertable(id,name,profession) values (?,?,?)",
                user.getId(),
                user.getName(),
                user.getProfession());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update("UPDATE usertable SET id=?,name=?,profession=? WHERE id=?",
                user.getId(),
                user.getName(),
                user.getProfession(),
                user.getId());
        return user;
    }

    @Override
    public String deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM usertable WHERE id=?",id);
        return id + " is removed";
    }

    @Override
    public List<User> findAll() {
        return  jdbcTemplate.query("SELECT * FROM usertable",
                new BeanPropertyRowMapper<>(User.class));
    }
}
