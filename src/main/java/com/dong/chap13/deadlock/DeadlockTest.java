package main.java.com.dong.chap13.deadlock;

public class DeadlockTest {

    public static void main(String[] args) {
        Sample sample = new Sample();
        Thread thread1 = new Thread(new Value1Thread(sample));
        Thread thread2 = new Thread(new Value2Thread(sample));

        thread1.start();
        thread2.start();
    }

    static class Value1Thread implements Runnable {

        private Sample sample;
        public Value1Thread (Sample sample) {
            this.sample = sample;
        }
        @Override
        public void run() {
            while (true)
                sample.addValue1();
        }
    }

    static class Value2Thread implements Runnable {

        private Sample sample;
        public Value2Thread (Sample sample) {
            this.sample = sample;
        }
        @Override
        public void run() {
            while (true)
                sample.addValue2();
        }
    }
    static class Sample {

        private Integer value1 = 1;
        private Integer value2 = 1;

        public void addValue1() {
            synchronized (value2) {
                System.out.println("value 2 is locked");
                synchronized (value1) {
                    value1++;
                    sleep(5);
                }
            }
        }

        public void addValue2 () {
            synchronized (value1) {
                System.out.println("value 1 is locked");
                synchronized (value2) {
                    value2++;
                    sleep(5);
                }
            }
        }

        private void sleep(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
