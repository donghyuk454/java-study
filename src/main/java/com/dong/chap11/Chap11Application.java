package main.java.com.dong.chap11;

import java.util.*;

public class Chap11Application {
    private static final int COUNT = 100000;

    public static void main(String[] args) {
        // 그냥 생성 시 10개의 객체만 받을 정도로만 생성함
        // 미리 capacity 를 입력해주면 성능을 향상시킬 수 있음

        List<SampleData> arrayList = new ArrayList<>();
        List<SampleData> fixedSizeArrayList = new ArrayList<>(COUNT + 10000);
        List<SampleData> linkedList = new LinkedList<>();

        checkMethodTime( Chap11Application::addItemInOrder, arrayList );          // time = 18 (첫 실행 시 오래 걸림..)
        checkMethodTime( Chap11Application::addItemInOrder, fixedSizeArrayList ); // time = 4
        // 하지만 count 를 1000000 으로 할 경우 전자가 더 성능이 좋음.
        // 이유를 모르겠다.

        // linked list 가 순차적인 생성에서 더 오래 걸림
        checkMethodTime( Chap11Application::addItemInOrder, arrayList );          // time = 5
        checkMethodTime( Chap11Application::addItemInOrder, linkedList );         // time = 19

        // linked list 가 중간에 추가할 땐 더 짧게 걸림
        checkMethodTime( Chap11Application::addItemInMiddle, arrayList );         // time = 4419
        checkMethodTime( Chap11Application::addItemInMiddle, linkedList );        // time = 105

        setElementByIterator(arrayList.iterator());
        setElementByForeach(arrayList);

        // comparator 를 사용해 collection 을 정렬하는 방법
        System.out.println("arrayList first value (not sorted) = " + arrayList.get(0).getA());
        arrayList.get(100).setA(1);
        arrayList.get(1000).setA(5);
        arrayList.sort((o1, o2) -> o1.getA() > o2.getA() ? -1 : 1);
        System.out.println("arrayList first value (sorted DESC) = " + arrayList.get(0).getA());
        arrayList.sort((o1, o2) -> o1.getA() > o2.getA() ? 1 : -1);
        System.out.println("arrayList first value (sorted ASC) = " + arrayList.get(0).getA());
    }

    private static void addItemInOrder(List<SampleData> list) {
        for (int i = 0; i < COUNT; i++) {
            list.add(new SampleData(1, "hi"));
        }
    }

    private static void addItemInMiddle(List<SampleData> list) {
        for (int i = 0; i < COUNT; i++) {
            list.add(500, new SampleData(1, "hi"));
        }
    }

    // List, Map, Set 에게 표준이 되는 함수
    private static void setElementByIterator (Iterator<SampleData> iterator) {
        while (iterator.hasNext()) {
            SampleData data = iterator.next();
            data.setA( data.getA() + 1 );
        }
    }

    // 아래와 같은 방식으로도 작성 가능하다.
    private static void setElementByForeach (Collection<SampleData> collection) {
        collection.forEach( data -> data.setA(data.getA() + 1) );
    }


    // ----------------------------utils----------------------------

    private static void checkMethodTime(MethodInterface methodInterface, List<SampleData> list) {
        long startTime = System.currentTimeMillis();
        methodInterface.doMethodBySampleDataList( list );
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("time = %d", (endTime - startTime)));
    }
}
