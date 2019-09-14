package com.kosmocoourses.java.junior.springhello.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private long id;
    private String body;
}
