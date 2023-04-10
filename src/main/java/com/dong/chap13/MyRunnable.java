package main.java.com.dong.chap13;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
//        printErrorMessage();
        printAnyMessage();
    }

    public void printErrorMessage() {
        try {
            throw new Exception("runnable thread error message");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAnyMessage() {
        System.out.println("-----thread2: start-----");
        for (int i = 0; i < 500; i++)
            System.out.print("2");
        System.out.println("\n-----thread2: done-----");
    }
}
