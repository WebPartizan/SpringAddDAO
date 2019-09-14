package com.kosmocoourses.java.junior.springhello.controler;

import com.kosmocoourses.java.junior.springhello.model.Message;
import com.kosmocoourses.java.junior.springhello.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    MessageService msgService;

    @RequestMapping("/")
    public String index() {
        return  "Привет ты пришел на самое крутое API";
    }

    @RequestMapping("/msg")
    public Message getMessage(@RequestParam(value = "u", defaultValue = "Jarwis") String username) {
        return msgService.getMessage(username);
    }
}
