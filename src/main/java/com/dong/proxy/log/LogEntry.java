package main.java.com.dong.proxy.log;

public class LogEntry {

    private static int LEVEL = 1;
    private final int level;
    private final String message;
    private final boolean isException;

    public LogEntry(String message) {
        level = LEVEL;
        LEVEL += 1;
        this.message = message;
        this.isException = false;
    }

    public LogEntry(int level, String message, boolean isException) {
        this.level = level;
        this.message = message;
        this.isException = isException;
    }

    public int getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public boolean isException() {
        return isException;
    }
}
