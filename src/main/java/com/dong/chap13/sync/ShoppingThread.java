package main.java.com.dong.chap13.sync;

public class ShoppingThread extends Thread {

    private final int price;
    private final Human human;

    public ShoppingThread (Human human, int price) {
        this.human = human;
        this.price = price;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                human.shopping(price);
            } catch (InterruptedException e) { }
        }
    }
}
