package main.java.com.dong.chap14.stream.controller.response.dto;

import main.java.com.dong.chap14.stream.enums.Job;

public class PopularJobDto {

    private final Job job;
    private final Long count;

    public PopularJobDto(Job job, Long count) {
        this.job = job;
        this.count = count;
    }

    public Job getJob() {
        return job;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "직업=" + job.getName() +
                ", count=" + count;
    }
}
