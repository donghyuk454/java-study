package main.java.com.dong.chap14.stream.entity;

import main.java.com.dong.chap14.stream.enums.Gender;
import main.java.com.dong.chap14.stream.enums.Job;

public class Person {
    private final Long id;
    private final String name;
    private final int age;
    private Job job;
    private final Gender gender;

    private static volatile long currentId = 0;

    public Person(String name, int age, Job job, Gender gender) {
        synchronized (this) {
            currentId += 1;
            this.id = currentId;
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Gender getGender() {
        return gender;
    }
}
