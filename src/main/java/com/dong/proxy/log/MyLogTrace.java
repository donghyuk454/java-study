package main.java.com.dong.proxy.log;

public class MyLogTrace implements LogTrace {
    @Override
    public void printLog(LogEntry logEntry) {

        for (int i = 0; i < logEntry.getLevel(); i++) {
            System.out.print("|--");
        }

        System.out.print("> ");

        if (logEntry.isException()) {
            System.out.print("Exception : ");
        }
        System.out.println(logEntry.getMessage());
    }
}
