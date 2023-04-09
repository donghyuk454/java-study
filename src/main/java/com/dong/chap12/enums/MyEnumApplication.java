package main.java.com.dong.chap12.enums;

public class MyEnumApplication {
    public static void main(String[] args) {
        Business business1 = Business.of("my first business" , Status.READY);
        Business business2 = Business.of("my second business" , Status.RUNNING);
        Business business3 = Business.of("my third business" , Status.END);

        System.out.println(business1.getMessage());
        System.out.println(business2.getMessage());
        System.out.println(business3.getMessage());
    }
}
