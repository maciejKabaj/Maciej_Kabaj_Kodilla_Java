package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> forumUsers = forum.getUserList().stream()
                .filter(f -> f.getGender() == 'M')
                .filter(f -> Period.between(f.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(f -> f.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, f -> f));

        forumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .forEach(System.out::println);
    }
}