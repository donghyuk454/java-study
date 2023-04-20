package main.java.com.dong.chap13.sync;

public class Wallet {
    private int money;

    public Wallet (int money) {
        this.money = money;
    }

    // synchronized 함수를 통해 동기화
    public synchronized void pay (int bill) {
        if (this.money < bill) {
            System.out.println("I don't have enough money !");
            return;
        }
        money -= bill;
        System.out.println("I paid " + bill +"!! My total money is " + this.money);
    }

    public synchronized void earn (int salary) {
        this.money += salary;
        System.out.println("I earned " + salary +"!! My total money is " + this.money);
    }

    public int getMoney() {
        return money;
    }
}
