package main.java.com.dong.chap13;

public class AdvancedThread implements Runnable {

    private boolean stopped = false;
    private boolean suspended = false;

    private final Thread thread;

    public AdvancedThread (String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException 발생 !");
                }
            } else {
                // 대기로 이동
                Thread.yield();
            }
        }
    }

    public void stop() {
        this.stopped = true;
        thread.interrupt(); // sleep 상태일 경우 InterruptedException 을 발생시키기 위해
    }

    public void suspend() {
        this.suspended = true;
        thread.interrupt(); // sleep 상태일 경우 InterruptedException 을 발생시키기 위해
    }

    public void resume() {
        this.suspended = false;
    }

    public void start() {
        thread.start();
    }
}
