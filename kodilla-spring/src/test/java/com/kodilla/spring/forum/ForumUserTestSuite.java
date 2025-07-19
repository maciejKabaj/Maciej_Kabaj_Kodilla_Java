package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForumUserTestSuite {

    @Autowired
    ForumUser forumUser;

    @Test
    void testGetUsernameAssignContext() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser user = context.getBean(ForumUser.class);
        //When
        String username = user.getUsername();
        //Then
        assertEquals("John Smith", username);
    }

    @Test
    void testGetUsernameAutowired() {
        //When
        String username = forumUser.getUsername();
        //Then
        assertEquals("John Smith", username);
    }
}
