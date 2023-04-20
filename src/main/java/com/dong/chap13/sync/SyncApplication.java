package main.java.com.dong.chap13.sync;

public class SyncApplication {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(10000);

        for (int i = 0; i < 15; i++) {
            PaymentThread paymentThread = new PaymentThread(i * 500, wallet);
            paymentThread.start();
        }
    }
}