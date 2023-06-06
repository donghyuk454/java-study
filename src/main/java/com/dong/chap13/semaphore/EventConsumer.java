package main.java.com.dong.chap13.semaphore;

public class EventConsumer implements Runnable {
    private final ResourceManager resourceManager;

    public EventConsumer() {
        this.resourceManager = ResourceManager.getInstance();
    }

    @Override
    public void run() {
        while (true){
            String value = null;
            try {
                value = resourceManager.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(value);
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
