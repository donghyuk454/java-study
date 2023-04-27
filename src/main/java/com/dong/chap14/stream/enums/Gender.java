package main.java.com.dong.chap14.stream.enums;

public enum Gender {
    MAN("남자"), WOMAN("여자");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
