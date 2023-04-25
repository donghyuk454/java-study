package main.java.com.dong.chap13.sync.lock;

public class Marketer implements Runnable {

    private final Buffet buffet;

    public Marketer(Buffet buffet) {
        this.buffet = buffet;
    }

    @Override
    public void run() {
        while (buffet.isOpen()) {
            this.buffet.doubleFoodCount();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
        }
    }
}
