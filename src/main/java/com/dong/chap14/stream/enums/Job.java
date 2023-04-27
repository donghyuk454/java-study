package main.java.com.dong.chap14.stream.enums;

public enum Job {
    DEVELOPER("개발자"), LAWYER("변호사"), DOCTOR("의사"), MARKETER("마케터");

    private final String name;

    Job(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
