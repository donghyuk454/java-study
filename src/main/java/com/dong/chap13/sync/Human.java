package main.java.com.dong.chap13.sync;

public class Human {

    private final String name;
    private final Wallet wallet;

    public Human(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void shopping(int price) {
        System.out.print("shopping! => ");
        this.wallet.pay(price);
    }

    public void work(int salary) {
        System.out.print("work! => ");
        this.wallet.earn(salary);
    }
}
