package com.kosmocoourses.java.junior.springhello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {

    @LocalServerPort
    private  int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws  Exception {
        this.base = new URL("http://localhost:" + port);
    }

    @Test
    public void getHelloMsgFromIndexPageTest() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);

        assertThat(response.getBody(), equalTo("Hello I'am know Spring Boot"));
    }
}
