package main.java.com.dong.chap13.sync;

public class PaymentThread extends Thread {
    int payment;
    Wallet wallet;

    public PaymentThread(int payment, Wallet wallet) {
        super();
        this.payment = payment;
        this.wallet = wallet;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            wallet.pay(payment);
        } catch (InterruptedException e) {
            System.out.println("interrupted !");
        }
    }
}
