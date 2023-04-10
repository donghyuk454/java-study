package main.java.com.dong.chap13;

public class Chap13Application {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);

        // run 으로 실행하면 그냥 main thread run 함수를 실행
        // 따라서 실행 시작이 main 함수
        thread1.run();

        // start 로 실행하면 새로운 thread 에서 run 함수를 실행
        // 실행 시작이 MyThread, MyRunnable run 함수
//        thread1.start();
//        thread2.start();

        // thread 에 우선순위를 부여할 수 있다.
        // 1~10 까지이며, 높을수록 우선순위가 높다.
        // 우선순위가 높다는 말은, 해당 thread 를 프로세스가 더 오랫동안 점유한다는 것!
        thread1.setPriority(5);
        thread2.setPriority(7);
        thread1.start();
        thread2.start();
    }
}




