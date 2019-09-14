package com.kosmocoourses.java.junior.springhello.dao;

import com.kosmocoourses.java.junior.springhello.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class MessageDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /** Метод отчечает за получение сообщений по "id" из БД*/
    @GetMapping
    public Message get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM messages WHERE id = " + id, Message.class);
    }

    /** Метод отчечает за создание сообщения пользователя*/
    public void create(Message message) {
        jdbcTemplate.execute("INSERT INTO messages (body)"+"VALUES ('"+ message.getBody() + ")");
    }

    /** Метод отвечает за удаление соообщения из БД*/
    public void delete(long id) {
        jdbcTemplate.execute("DELETE FROM messages WHERE id = " + id);
    }

}
