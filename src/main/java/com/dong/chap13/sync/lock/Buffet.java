package main.java.com.dong.chap13.sync.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Buffet {

    private static Buffet buffet;
    private long foodCount = 0;
    private boolean isOpen = true;
    private final ReentrantLock lock = new ReentrantLock();

    private Buffet() { }


    // 싱글톤 패턴 동기화 ( static class 를 사용한 Lazy Initialization )
    private static class BuffetHolder {
        private static final Buffet INSTANCE = new Buffet();
    }

    public static Buffet getInstance() {
        return BuffetHolder.INSTANCE;
    }

//    //싱글톤 패턴 동기화 ( Eager Initialization )
//    private static Buffet buffet = new Buffet();

//     //싱글톤 패턴 동기화 ( double checked lock )
//    public static Buffet getInstance() {
//        if (buffet == null) {
//            synchronized (Buffet.class) {
//                if (buffet == null) {
//                    buffet = new Buffet();
//                }
//            }
//        }
//        return buffet;
//    }

//    // 싱글톤 패턴 동기화 ( synchronized )
//    public synchronized static Buffet getInstance() {
//        if (buffet == null) {
//            buffet = new Buffet();
//        }
//        return buffet;
//    }

    public void addFoodCount(int number) {
        lock.lock();
        try {
            System.out.println("cooking! " + number);
            this.foodCount += number;
            System.out.println("remain " + foodCount);
        } finally {
            lock.unlock();
        }
    }

    public void subtractFoodCount(int number) {
        lock.lock();
        try {
            System.out.println("eat! " + number);
            if (this.foodCount >= number){
                this.foodCount -= number;
            }
            System.out.println("remain " + foodCount);
        } finally {
            lock.unlock();
        }

    }

    public void doubleFoodCount() {
        lock.lock();
        try {
            System.out.println("event! ");
            this.foodCount *= 2;
            System.out.println("remain " + foodCount);
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
