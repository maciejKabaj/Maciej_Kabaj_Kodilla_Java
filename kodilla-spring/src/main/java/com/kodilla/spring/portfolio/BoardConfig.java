package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard(
            @Qualifier("toDoList") TaskList toDo,
            @Qualifier("inProgressList") TaskList inProgress,
            @Qualifier("doneList") TaskList done
    ) {
        return new Board(toDo, inProgress, done);
    }


    @Bean
    @Qualifier("toDoList")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean
    @Qualifier("inProgressList")
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean
    @Qualifier("doneList")
    public TaskList doneList() {
        return new TaskList();
    }
}
