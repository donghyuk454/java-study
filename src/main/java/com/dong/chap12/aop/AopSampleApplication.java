package main.java.com.dong.chap12.aop;

import main.java.com.dong.chap12.aop.domain.MyInfo;
import main.java.com.dong.chap12.aop.service.EnglishService;
import main.java.com.dong.chap12.aop.service.KoreanService;
import main.java.com.dong.chap12.aop.service.MyService;
import main.java.com.dong.chap12.aop.util.MyDictionary;

public class AopSampleApplication {
    public static void main(String[] args) {
        MyInfo myInfo = new MyInfo("이동혁", 28, new String[]{"soccer", "야구", "game"});

        MyDictionary myDictionary = new MyDictionary();
        MyService myKorService = new KoreanService(myDictionary);
        MyService myEngService = new EnglishService(myDictionary);

        MyAopProxy proxy = new MyAopProxy();

        proxy.question1(myEngService, myInfo, true);
        proxy.question1(myKorService, myInfo, false);
    }
}
