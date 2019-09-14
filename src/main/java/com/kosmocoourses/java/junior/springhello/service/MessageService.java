package com.kosmocoourses.java.junior.springhello.service;

import com.kosmocoourses.java.junior.springhello.model.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    private final static String template = "Привет %s!";
    private final AtomicLong counter = new AtomicLong();

    public Message getMessage(String username) {

        return Message.builder()
                .id(counter.incrementAndGet())
                .body(String.format(template, username))
                .build();
    }
}
