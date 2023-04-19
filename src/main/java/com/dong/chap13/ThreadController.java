package main.java.com.dong.chap13;

public class ThreadController {

    public static void main(String[] args) throws InterruptedException {
        ThreadController threadController = new ThreadController();
        threadController.control();
    }

    private void control () throws InterruptedException {
        NewThread newThread = new NewThread("-");
        newThread.start();
        Thread.sleep(1);

        // 쓰레드를 외부에서 interrupt 시킬 수 있다.
        // 단, interrupt 는 강제로 실행을 종료하는 것이 아님. 요청만 보내는 것 (내부 인스턴스 변수인 interrupted 값만 변경됨)
        System.out.println("\nIs new thread interrupted : " + newThread.isInterrupted());
        newThread.interrupt();
        System.out.println("Is new thread interrupted : " + newThread.isInterrupted());

        Thread.sleep(1000);
        NewSleepThread newSleepThread = new NewSleepThread();
        System.out.println();
        newSleepThread.start();
        Thread.sleep(500);
        newSleepThread.interrupt();

        /* sleep 인 경우엔 join 이 정상 작동하지 않는다... */
        AdvancedThread advancedThread1 = new AdvancedThread("thread 1");
        AdvancedThread advancedThread2 = new AdvancedThread("thread 2");
        advancedThread1.start();
        advancedThread2.start();

        Thread.sleep(2000);
        advancedThread1.interrupt(); // main 쓰레드가 advancedThread1 을 기다림
        advancedThread1.join(1500);
        advancedThread1.interrupt();
        Thread.sleep(2000);
        advancedThread2.join(); // main 쓰레드가 advancedThread2 을 기다림

        // 따라서 advancedThread2 가 끝날때까지 실행되지 않음
        NewThread newThread1 = new NewThread("1");
        NewThread newThread2 = new NewThread("2");
        newThread1.start();
        newThread2.start();

        Thread.sleep(5);
        newThread1.join(10); // main 쓰레드가 newThread1 을 기다림
        newThread2.join(10); // main 쓰레드가 newThread2 를 기다림
        Thread.sleep(100);
        System.out.println("interrupt!!");
        newThread1.interrupt();
        newThread2.interrupt();
        Thread.sleep(100);
        System.out.println("End !");
    }

    static class NewThread extends Thread {
        public NewThread ( String name ) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("thread start");
            while (!interrupted()) { // interrupt 되기 전까지 안에 있는 코드가 실행됨
                System.out.print(this.getName());
            }
            System.out.println("New Thread is interrupted !");
        }
    }

    static class NewSleepThread extends Thread {
        @Override
        public void run() {
            int sleepTime = 2000;
            System.out.println("New Sleep Thread sleep "
                                + sleepTime +" mills");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("sleep thread interrupted !");
                // 이 코드가 없으면 외부에서 interrupt 해도, sleep 때문에 InterruptedException 이 발생
                // 이후에 interrupted 상태가 false 로 바뀌므로 아래와 같이 interrupt 을 실행해야함.
                this.interrupt();
            }
            if (!interrupted()) // interrupt 되면 실행되지 않음. 반대로, interrupt 되지 않으면 실행됨
                System.out.println("This thread is not interrupted !");
        }
    }

}
