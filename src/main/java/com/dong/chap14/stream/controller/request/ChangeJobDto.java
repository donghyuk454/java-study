package main.java.com.dong.chap14.stream.controller.request;

import main.java.com.dong.chap14.stream.enums.Job;

public class ChangeJobDto {
    private final Long id;
    private final Job job;

    public ChangeJobDto(Long id, Job job) {
        this.id = id;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }
}
