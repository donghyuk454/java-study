package main.java.com.dong.chap13.lock_free;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeTest {

    public static void main(String[] args) throws InterruptedException {
//        LockStack<Integer> stack = new LockStack<>();
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            stack.push(random.nextInt());
        }

        List<Thread> threads = new ArrayList<>();

        int pushCnt = 2;
        int popCnt = 2;

        for(int i = 0; i < pushCnt; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    stack.push(random.nextInt());
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }

        for(int i = 0; i < popCnt; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    stack.pop();
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10000);

        System.out.println(stack.getResult());
    }

    static class LockFreeStack<T> {
        AtomicInteger pushCount = new AtomicInteger(0);
        AtomicInteger popCount = new AtomicInteger(0);
        AtomicReference<Node<T>> head = new AtomicReference<>();


        public void push(T obj) {
            Node<T> newNode = new Node<>();
            newNode.value = obj;

            while (true) {
                Node<T> currentNode = head.get();
                newNode.next = currentNode;

                if (head.compareAndSet(currentNode, newNode)) {
                    pushCount.incrementAndGet();
                    return;
                }

                LockSupport.parkNanos(1);
            }
        }

        public T pop() {
            Node<T> currentNode = head.get();
            Node<T> nextNode;

            while (currentNode != null) {
                nextNode = currentNode.next;

                if (head.compareAndSet(currentNode, nextNode)) {
                    popCount.incrementAndGet();
                    return currentNode.value;
                }

                LockSupport.parkNanos(1);
                currentNode = head.get();
            }

            return null;
        }

        public String getResult() {
            return "Pop operations : " +
                    popCount.get() +
                    ", Push operations : " +
                    pushCount.get();
        }
    }

    static class LockStack<T> {
        AtomicInteger pushCount = new AtomicInteger(0);
        AtomicInteger popCount = new AtomicInteger(0);
        Node<T> head;

        public synchronized void push(T obj) {
            Node<T> node = new Node<>();
            node.value = obj;
            node.next = head;
            head = node;
            pushCount.incrementAndGet();
        }

        public synchronized T pop() {
            if (head == null)
                return null;
            T result = head.value;
            head = head.next;
            popCount.incrementAndGet();

            return result;
        }

        public String getResult() {
            return "Pop operations : " +
                    popCount.get() +
                    ", Push operations : " +
                    pushCount.get();
        }
    }

    static class Node<T> {
        public T value;
        public Node<T> next;
    }
}
