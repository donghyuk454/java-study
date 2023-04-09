package main.java.com.dong.chap12.enums;

public enum Status {
    READY("this is ready"), RUNNING("this is running"), END("this is ended");

    private final String myStatusInfo;

    Status (String info) {
        this.myStatusInfo = info;
    }

    public String getMyStatusInfo() {
        return myStatusInfo;
    }
}
