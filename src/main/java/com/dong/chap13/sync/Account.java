package main.java.com.dong.chap13.sync;

public class Account {
    private int money;

    public Account (int money) {
        this.money = money;
    }

    // synchronized 함수를 통해 동기화
    public synchronized void pay (int bill) throws InterruptedException {
        if (this.money < bill) {
            System.out.println("I don't have enough money !");
            return;
        }
        money -= bill;
        System.out.println("I paid " + bill +"!! My total money is " + this.money);
    }
}
