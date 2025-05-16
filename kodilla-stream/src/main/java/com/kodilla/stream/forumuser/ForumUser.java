package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int id;
    private final String username;
    private final char gender;
    private final LocalDate birthDate;
    private int postCount;

    public ForumUser(int id, String username, char gender, LocalDate birthDate, int postCount) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postCount = postCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", postCount=" + postCount +
                '}';
    }
}
