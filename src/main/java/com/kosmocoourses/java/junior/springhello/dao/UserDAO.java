package com.kosmocoourses.java.junior.springhello.dao;

import com.kosmocoourses.java.junior.springhello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = " + id, User.class);
    }

    public void create(User user) {
        jdbcTemplate.execute("INSERT INTO users (username, login, password, email, isactive)" +
                "VALUES ('" + user.getName() + "', '"
                + user.getLogin() + "', '"
                + user.getPassword() + "', '"
                + user.getEmail() + "', "
                + user.isActive() + ")");
    }

    public void update(User user) {
        jdbcTemplate.execute("UPDATE users SET username = '" + user.getName()
                + "', login = '" + user.getLogin()
                + "', password = '"+ user.getPassword()
                + "', email = '"+ user.getEmail()
                + "', isactive = ");
    }

    public void delete(long id) {
        jdbcTemplate.execute("DELETE FROM users WHERE id = " + id);
    }

    public List<User> getUsersByEmail(String email) {

        String sql = "SELECT * FROM user WHERE email = ?";

        return jdbcTemplate.query(sql, new Object[]{email},
                new BeanPropertyRowMapper(User.class));
    }

    public List<User> getActiveUsers() {
        List<User> users = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM user WHERE isactive = true");
        for (Map row: rows) {
            User user = new User();

            user.setId((Long) row.get("id"));
            user.setName((String) row.get("username"));
            user.setLogin((String) row.get("login"));
            user.setPassword((String) row.get("password"));
            user.setPassword((String) row.get("email"));
            user.setActive((Boolean) row.get("isactive"));

            users.add(user);
        }
        return users;
    }

    public void updateEmail(long id, String email) {
        // enter your code
    }

    public void updateUsername(long id, String email) {
        // enter your code
    }
}
