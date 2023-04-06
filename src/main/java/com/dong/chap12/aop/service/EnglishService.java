package main.java.com.dong.chap12.aop.service;

import main.java.com.dong.chap12.aop.domain.MyInfo;
import main.java.com.dong.chap12.aop.util.MyDictionary;

public class EnglishService implements MyService {

    private final MyDictionary dictionary;

    public EnglishService(MyDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String introduceMyself(MyInfo myInfo) {
        String name = myInfo.getName();
        StringBuilder stringBuilder = new StringBuilder()
                .append("Hi! My name is ");
        if (dictionary.isEnglish(name)) {
            stringBuilder.append(name);
        } else {
            stringBuilder.append(dictionary.koreanToEnglish(name));
        }
        stringBuilder.append(".\n")
            .append("Nice to meet you!\n")
            .append("I'm ")
            .append(myInfo.getAge())
            .append(" years old.\nAnd my hobbies are ");

        String[] hobbies =  myInfo.getHobbies();
        for (String hobby : hobbies) {
            if (dictionary.isEnglish(hobby)) {
                stringBuilder.append(hobby);
            } else {
                stringBuilder.append(dictionary.koreanToEnglish(hobby));
            }
            stringBuilder.append(", ");
        }
        int end = stringBuilder.length();
        stringBuilder.delete(end-2, end);
        stringBuilder.append(".\n");

        return stringBuilder.toString();
    }

    @Override
    public String haveHobby(String hobby, MyInfo myInfo) {
        for (String myHobby : myInfo.getHobbies()) {
            if(myHobby.equals(hobby))
                return "yes!\n";
        }
        return "no!\n";
    }
}
