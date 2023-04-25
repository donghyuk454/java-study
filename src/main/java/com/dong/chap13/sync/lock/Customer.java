package main.java.com.dong.chap13.sync.lock;

public class Customer implements Runnable{

    private final Buffet buffet;
    private final int foodPower;

    public Customer(Buffet buffet, int foodPower) {
        this.buffet = buffet;
        this.foodPower = foodPower;
    }

    public void eatFood() {
        buffet.subtractFoodCount(foodPower);
    }

    @Override
    public void run() {
        while (buffet.isOpen()) {
            this.eatFood();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }
    }
}
