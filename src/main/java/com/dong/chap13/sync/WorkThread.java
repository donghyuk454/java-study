package main.java.com.dong.chap13.sync;

public class WorkThread extends Thread {

    private final Human human;
    private final int salary;

    public WorkThread (Human human, int salary) {
        this.human = human;
        this.salary = salary;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                human.work(salary);
            } catch (InterruptedException e) { }
        }
    }
}
