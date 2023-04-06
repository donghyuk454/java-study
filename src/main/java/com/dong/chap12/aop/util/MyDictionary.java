package main.java.com.dong.chap12.aop.util;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {
    private static Map<String, String> dictionaryEngToKor;
    private static Map<String, String> dictionaryKorToEng;

    static {
        dictionaryKorToEng = new HashMap<>();
        dictionaryKorToEng.put("이동혁", "LEE Dong-hyuk");
        dictionaryKorToEng.put("축구", "soccer");
        dictionaryKorToEng.put("게임", "game");
        dictionaryKorToEng.put("야구", "baseball");
        dictionaryKorToEng.put("농구", "basketball");

        dictionaryEngToKor = new HashMap<>();
        dictionaryKorToEng.forEach((key, value) -> dictionaryEngToKor.put(value, key));
    }

    public String englishToKorean (String word) {
        return dictionaryEngToKor.get(word);
    }

    public String koreanToEnglish (String word) {
        return dictionaryKorToEng.get(word);
    }

    public boolean isEnglish (String word) {
        return dictionaryEngToKor.containsKey(word);
    }
}
