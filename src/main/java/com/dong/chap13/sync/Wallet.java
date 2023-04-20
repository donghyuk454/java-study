package main.java.com.dong.chap13.sync;

public class Wallet {
    private int money;

    public Wallet (int money) {
        this.money = money;
    }

    // synchronized 함수를 통해 동기화
    public synchronized void pay (int bill) {
        if (this.money < bill) {
            System.out.println("you can't buy !");
            return;
        }
        money -= bill;
        System.out.println("My total: " + this.money);
    }

    public int getMoney() {
        return money;
    }
}
