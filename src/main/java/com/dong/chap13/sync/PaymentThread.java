package main.java.com.dong.chap13.sync;

public class PaymentThread extends Thread {
    int payment;
    Account account;

    public PaymentThread(int payment, Account account) {
        super();
        this.payment = payment;
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            account.pay(payment);
        } catch (InterruptedException e) {
            System.out.println("interrupted !");
        }
    }
}
