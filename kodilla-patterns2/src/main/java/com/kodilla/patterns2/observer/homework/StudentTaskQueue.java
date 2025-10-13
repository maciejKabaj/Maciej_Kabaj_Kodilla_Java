package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTaskQueue implements ObservableTasks {

    private final List<ObserverTasks> observers;
    private final List<String> tasks;
    private final String name;

    public StudentTaskQueue(String name) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(ObserverTasks observerTasks) {
        observers.add(observerTasks);
    }

    @Override
    public void notifyObservers() {
        for (ObserverTasks observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(ObserverTasks observerTasks) {
        observers.remove(observerTasks);
    }

    public List<ObserverTasks> getObservers() {
        return observers;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
