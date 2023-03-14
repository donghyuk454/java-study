package main.java.com.dong.chap9;


public class Chap9Application {
    public static void main(String[] args) {
        ObjectSample objectSample = new ObjectSample(1, 2);
        ObjectSample objectSample1 = new ObjectSample(1, 2);

        System.out.println(objectSample.equals(objectSample1));

        System.out.println(objectSample.hashCode());
        System.out.println(objectSample1.hashCode());

        // clone 관련 예제 1
        try {
            ObjectSample objectSample2 = objectSample.clone();

            System.out.println(objectSample2.equals(objectSample));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // clone 관련 예제 2
        CloneSample cloneSample = new CloneSample(new ObjectSample(1, 2), new ObjectSample(3, 4));
        CloneSample clone = cloneSample.clone();

        clone.objectSample1.setA(10);
        System.out.println("cloneSample.a = " + cloneSample.objectSample1.getA());
        cloneSample.objectSample1.setA(1);

        clone = cloneSample.deepCopy();
        clone.objectSample1.setA(10);
        System.out.println("cloneSample.a = " + cloneSample.objectSample1.getA());

        // String 관련 예제
        String str1 = "aaa";
        String str2 = "aaa";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        String str3 = new String("aaa");
        String str4 = new String("aaa");
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
    }
}
