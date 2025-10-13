package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObserverTasks {

    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(StudentTaskQueue queue) {
        System.out.println(username + ", you've got tasks to process!");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
