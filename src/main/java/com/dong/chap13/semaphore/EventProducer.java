package main.java.com.dong.chap13.semaphore;

public class EventProducer implements Runnable{
    private final ResourceManager resourceManager;
    private final String name;
    private int count = 0;

    public EventProducer(String name) {
        this.resourceManager = ResourceManager.getInstance();
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            resourceManager.produce("Name: " + name + ", Count: " + count);
            count++;
            sleep(10);
        }
    }

    private static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
