package main.java.com.dong.chap13;

public class ThreadController {

    public static void main(String[] args) throws InterruptedException {
        ThreadController threadController = new ThreadController();
        threadController.control();
    }

    private void control () throws InterruptedException {
        NewThread newThread = new NewThread();
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

    }

    static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread start");
            while (!interrupted()) { // interrupt 되기 전까지 안에 있는 코드가 실행됨
                System.out.print("-");
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
