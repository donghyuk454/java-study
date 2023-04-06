package main.java.com.dong.chap12.aop.service;

import main.java.com.dong.chap12.aop.domain.MyInfo;
import main.java.com.dong.chap12.aop.util.MyDictionary;

public class KoreanService implements MyService {

    private final MyDictionary dictionary;

    public KoreanService(MyDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String introduceMyself(MyInfo myInfo) {
        String name = myInfo.getName();
        StringBuilder stringBuilder = new StringBuilder()
                .append("안녕! 내 이름은 ");
        if (dictionary.isEnglish(name)) {
            stringBuilder.append(dictionary.englishToKorean(name));
        } else {
            stringBuilder.append(name);
        }
        stringBuilder.append(".\n")
                .append("만나서 반가워!\n")
                .append("나는 ")
                .append(myInfo.getAge())
                .append("살이야.\n내 취미는 ");

        String[] hobbies =  myInfo.getHobbies();
        for (String hobby : hobbies) {
            if (dictionary.isEnglish(hobby)) {
                stringBuilder.append(dictionary.englishToKorean(hobby));
            } else {
                stringBuilder.append(hobby);
            }
            stringBuilder.append(", ");
        }
        int end = stringBuilder.length();
        stringBuilder.delete(end-2, end);
        stringBuilder.append("!\n");

        return stringBuilder.toString();
    }

    @Override
    public String haveHobby(String hobby, MyInfo myInfo) {
        for (String myHobby : myInfo.getHobbies()) {
            if(myHobby.equals(hobby))
                return "응!\n";
        }
        return "아니!\n";
    }
}
