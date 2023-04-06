package main.java.com.dong.chap12.aop;

import main.java.com.dong.chap12.aop.domain.MyInfo;
import main.java.com.dong.chap12.aop.service.MyService;

public class MyAopProxy {

    private final String line = "----------------------------------";

    // Aspect
    public void question1 (MyService myService, MyInfo myInfo, boolean isEng) {
        // Advice
        System.out.println(line);
        String intro = isEng ? "Who are you?\n" : "너는 누구니?\n";
        System.out.println(intro);

        // Pointcut
        System.out.println(myService.introduceMyself(myInfo));

        // Advice
        String outro = isEng ? "okay~" : "그렇구나~";
        System.out.println(outro);
        System.out.println(line);
    }

    // Aspect
    public void question2 (MyService myService, MyInfo myInfo, String hobby, boolean isEng) {
        // Advice
        System.out.println(line);
        String intro = isEng ? "Who are you?\n" : "너는 누구니?\n";
        System.out.println(intro);

        // Pointcut
        System.out.println(myService.haveHobby(hobby, myInfo));

        // Advice
        String outro = isEng ? "okay~" : "그렇구나~";
        System.out.println(outro);
        System.out.println(line);
    }
}
