package main.java.com.dong.chap12.aop.service;

import main.java.com.dong.chap12.aop.domain.MyInfo;

public interface MyService {
    String introduceMyself ( MyInfo myInfo );

    String haveHobby ( String hobby, MyInfo myInfo );
}
