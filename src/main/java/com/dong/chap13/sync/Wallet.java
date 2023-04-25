package main.java.com.dong.chap13.sync;

public class Wallet {
    private int money;

    public Wallet (int money) {
        this.money = money;
    }

    // synchronized 함수를 통해 동기화
    // 돈이 없는 경우, 월급을 받을 때까지 wait !
    public synchronized void pay (int bill) throws InterruptedException {
        if (this.money < bill) {
            wait();
        }
        money -= bill;
        System.out.println("I paid " + bill +"!! My total money is " + this.money);
        notify();
    }

    // 월급을 받은 사실을 notify 나 notifyAll 을 통해 알린다 !
    public synchronized void earn (int salary) {
        this.money += salary;
        System.out.println("I earned " + salary +"!! My total money is " + this.money);
        notifyAll();
    }
}
