package main.java.com.dong.chap13.sync;

public class SyncApplication {

    public static void main(String[] args) throws InterruptedException {
        Wallet wallet = new Wallet(10000);

        for (int i = 0; i < 15; i++) {
            PaymentThread paymentThread = new PaymentThread(i * 500, wallet);
            paymentThread.start();
        }


        Thread.sleep(2000);
        System.out.println("-------------------------\n");
        Human human = new Human("이동혁", new Wallet(15000));

        Thread workThread = new WorkThread(human, 10000);
        Thread shoppingThread = new ShoppingThread(human, 1000);
        shoppingThread.start();
        workThread.start();
    }
}