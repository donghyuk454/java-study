package main.java.com.dong.chap11;

import java.util.ArrayList;
import java.util.List;

public class Chap11Application {
    public static void main(String[] args) {

        // 그냥 생성 시 10개의 객체만 받을 정도로만 생성함
        // 미리 capacity 를 입력해주면 성능을 향상시킬 수 있음
        int count = 100000;
        long startTime = System.currentTimeMillis();
        List list1 = new ArrayList<SampleData>();

        for (int i = 0; i < count; i++) {
            list1.add(new SampleData(1, "hi"));
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("time = " + time); // time = 14

        startTime = System.currentTimeMillis();
        List list2 = new ArrayList<SampleData>(count + 10000);

        for (int i = 0; i < count; i++) {
            list1.add(new SampleData(1, "hi"));
        }

        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println("time = " + time); // time = 5

        // 하지만 count 를 1000000 으로 할 경우 전자가 더 성능이 좋음.
        // 이유를 모르겠다.
    }
}
