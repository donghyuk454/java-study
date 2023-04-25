package main.java.com.dong.chap13.sync.lock;

public class BuffetApplication {
    public static void main(String[] args) {
        // init
        Buffet buffet = Buffet.getInstance();
        Thread customer1 = new Thread(new Customer(buffet, 100000000));
        Thread customer2 = new Thread(new Customer(buffet, 200000000));
        Thread customer3 = new Thread(new Customer(buffet, 300000000));
        Thread customer4 = new Thread(new Customer(buffet, 400000000));

        Thread cook1 = new Thread(new Cook(buffet, 100000000));
        Thread cook2 = new Thread(new Cook(buffet, 100000000));

        Thread marketer = new Thread(new Marketer(buffet));

        cook1.start();
        cook2.start();

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();

        marketer.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            buffet.close();
        }
    }
}
