package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        int userListSize = 10;
        Random random = new Random();
        for (int i = 1; i <= userListSize; i++) {
            String username = "user" + i;
            char gender = random.nextBoolean() ? 'M' : 'F';
            int year = 2000 + random.nextInt(11);
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(YearMonth.of(year, month).lengthOfMonth()) + 1;
            LocalDate birthDate = LocalDate.of(year, month, day);
            int postCount = random.nextInt(6);
            userList.add(new ForumUser(i, username, gender, birthDate, postCount));
            /*
            userList.add(new ForumUser(1, "user1", 'M', LocalDate.of(1990, 1, 16), 0));
            userList.add(new ForumUser(2, "user2", 'F', LocalDate.of(1991, 12, 15), 2));
            userList.add(new ForumUser(3, "user3", 'F', LocalDate.of(1992, 2, 18), 12));
            userList.add(new ForumUser(4, "user4", 'M', LocalDate.of(2000, 4, 21), 13));
            userList.add(new ForumUser(5, "user5", 'M', LocalDate.of(2001, 5, 21), 8));
            userList.add(new ForumUser(6, "user6", 'F', LocalDate.of(2001, 8, 29), 7));
            userList.add(new ForumUser(7, "user7", 'M', LocalDate.of(2000, 1, 3), 0));
            userList.add(new ForumUser(8, "user8", 'M', LocalDate.of(2007, 3, 1), 1));
            userList.add(new ForumUser(9, "user9", 'M', LocalDate.of(2006, 5, 10), 3));
            userList.add(new ForumUser(10, "user10", 'M', LocalDate.of(2010, 9, 19), 5));
             */
        }
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
