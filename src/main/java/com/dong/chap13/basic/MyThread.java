package main.java.com.dong.chap13.basic;

public class MyThread extends Thread {
    @Override
    public void run() {
//        printErrorMessage();
        printAnyMessage();
    }

    public void printErrorMessage() {
        try {
            throw new Exception("thread error message");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAnyMessage() {
        System.out.println("-----thread1: start-----");
        for (int i = 0; i < 500; i++)
            System.out.print("1");
        System.out.println("\n-----thread1: done-----");
    }
}
