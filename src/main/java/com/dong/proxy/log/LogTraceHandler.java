package main.java.com.dong.proxy.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceHandler implements InvocationHandler {

    private final LogTrace logTrace;
    private final Object target;

    public LogTraceHandler(LogTrace logTrace, Object target) {
        this.logTrace = logTrace;
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String message = method.getDeclaringClass().getName() +
                " " + method.getName();

        LogEntry logEntry = new LogEntry(message);
        logTrace.printLog(logEntry);

        try {
            method.invoke(target, args);
            logTrace.printLog(logEntry);
        } catch (Exception e) {
            LogEntry logExceptionEntry = new LogEntry(logEntry.getLevel(), message, true);
            logTrace.printLog(logExceptionEntry);
            throw e;
        }
        return null;
    }
}
