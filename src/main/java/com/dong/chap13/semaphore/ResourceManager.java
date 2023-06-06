package main.java.com.dong.chap13.semaphore;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceManager {
    private static final int MAX_COUNT = 2;
    private static ResourceManager resourceManager = new ResourceManager();

    private final Semaphore semaphore = new Semaphore(MAX_COUNT);
    private final ReentrantLock reentrantLock = new ReentrantLock();

    private final ArrayDeque<String> queue = new ArrayDeque<>();

    public static ResourceManager getInstance() {
        if (resourceManager == null) {
            resourceManager = new ResourceManager();
        }

        return resourceManager;
    }

    public void produce(String str) {
        reentrantLock.lock();
        try {
            queue.offer(str);
            semaphore.release();
        } finally {
            reentrantLock.unlock();
        }
    }

    public String consume() throws InterruptedException {
        semaphore.acquire();
        reentrantLock.lock();
        try {

            return queue.poll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            String name = "Thread" + i;
            Thread thread = new Thread(new EventProducer(name));
            thread.start();
        }

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new EventConsumer());
            thread.start();
        }

        sleep(10000);
    }

    private static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
