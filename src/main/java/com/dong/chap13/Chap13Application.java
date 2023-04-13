package main.java.com.dong.chap13;

public class Chap13Application {
    public static void main(String[] args) throws InterruptedException{
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


        Thread.sleep(1000);
        System.out.println("\n");

        // main 쓰레드 그룹
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup threadGroup = new ThreadGroup("Thread Group 1");
        ThreadGroup subThreadGroup = new ThreadGroup(threadGroup, "Thread Group 2");

        Runnable runnable1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread3 = new Thread(threadGroup, runnable1);
        Thread thread4 = new Thread(subThreadGroup, runnable1);
        thread3.start();
        thread4.start();

        System.out.println("--------- Main Thread Group Information -----------");
        System.out.println("Thread name : " + mainThreadGroup.getName()
                + "\n - Active thread count : " + mainThreadGroup.activeCount()
                + "\n - Active thread group count : " + mainThreadGroup.activeGroupCount()
                + "\n - Is parent of threadGroup : " + mainThreadGroup.parentOf(threadGroup)
                + "\n - Is parent of subThreadGroup : " + mainThreadGroup.parentOf(subThreadGroup)
                + "\n - Parent Name: " + mainThreadGroup.getParent().getName()
                + "\n");

        System.out.println("--------- Thread Group Information -----------");
        System.out.println("Thread name : " + threadGroup.getName()
                + "\n - Active thread count : " + threadGroup.activeCount()
                + "\n - Active thread group count : " + threadGroup.activeGroupCount()
                + "\n - Is parent of mainThreadGroup : " + threadGroup.parentOf(mainThreadGroup)
                + "\n - Is parent of subThreadGroup : " + threadGroup.parentOf(subThreadGroup)
                + "\n - Parent Name: " + threadGroup.getParent().getName()
                + "\n");

        System.out.println("--------- Thread Group Information -----------");
        System.out.println("Thread name : " + subThreadGroup.getName()
                + "\n - Active thread count : " + subThreadGroup.activeCount()
                + "\n - Active thread group count : " + subThreadGroup.activeGroupCount()
                + "\n - Is parent of mainThreadGroup : " + subThreadGroup.parentOf(mainThreadGroup)
                + "\n - Is parent of threadGroup : " + subThreadGroup.parentOf(threadGroup)
                + "\n - Parent Name: " + subThreadGroup.getParent().getName()
                + "\n");

        System.out.println("--------- Main Thread Group List -----------");

        mainThreadGroup.list();
    }
}




