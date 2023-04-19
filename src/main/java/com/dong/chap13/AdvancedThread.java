package main.java.com.dong.chap13;

public class AdvancedThread implements Runnable {

    private static final int MAX_COUNT = 10;

    private boolean stopped = false;
    private boolean suspended = false;
    private int count = 0;

    private final Thread thread;

    public AdvancedThread (String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        while (!stopped && getCount() < MAX_COUNT) {
            if (!suspended) {
                try {
                    System.out.println(this.thread.getName() + " sleep~ Zzz | count : " + getCount());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException 발생 !");
                }
            } else {
                // 대기로 이동
                Thread.yield();
            }
            setCount( getCount() + 1 );
        }
    }

    public void interrupt() {
        this.thread.interrupt();
    }

    public void stop() {
        this.stopped = true;
        thread.interrupt(); // sleep 상태일 경우 InterruptedException 을 발생시키기 위해
    }

    public void suspend() {
        this.suspended = true;
        thread.interrupt(); // sleep 상태일 경우 InterruptedException 을 발생시키기 위해
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }

    public void join(long millis) throws InterruptedException {
        this.thread.join(millis);
    }

    public void resume() {
        this.suspended = false;
    }

    public void start() {
        thread.start();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
