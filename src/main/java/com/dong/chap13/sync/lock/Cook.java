package main.java.com.dong.chap13.sync.lock;

public class Cook implements Runnable{

    private final Buffet buffet;
    private final int foodCount;

    public Cook(Buffet buffet, int foodCount) {
        this.buffet = buffet;
        this.foodCount = foodCount;
    }

    public void addFood () {
        buffet.addFoodCount(foodCount);
    }

    @Override
    public void run() {
        while (buffet.isOpen()) {
            this.addFood();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
