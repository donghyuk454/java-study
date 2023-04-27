package main.java.com.dong.chap14.stream;

import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Gender;
import main.java.com.dong.chap14.stream.enums.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataManager {

    private static List<Person> data = new ArrayList<>();

    private DataManager(){}

    static {
        data.add(new Person("이동혁", 28, Job.DEVELOPER, Gender.MAN));
        data.add(new Person("짱구", 12, Job.LAWYER, Gender.MAN));
        data.add(new Person("철수", 15, Job.DEVELOPER, Gender.MAN));
        data.add(new Person("영희", 11, Job.DOCTOR, Gender.WOMAN));
        data.add(new Person("김덕배", 30, Job.MARKETER, Gender.MAN));
        data.add(new Person("김두한", 45, Job.DEVELOPER, Gender.MAN));
        data.add(new Person("이지환", 22, Job.DEVELOPER, Gender.MAN));
        data.add(new Person("김채원", 22, Job.LAWYER, Gender.WOMAN));
        data.add(new Person("유리", 5, Job.MARKETER, Gender.WOMAN));
        data.add(new Person("훈이", 17, Job.DOCTOR, Gender.MAN));
        data.add(new Person("맹구", 8, Job.DEVELOPER, Gender.MAN));
    }

    public static List<Person> getData() {
        return data;
    }

    public static void persist(Person person) {
        Long id = person.getId();
        AtomicBoolean isPresent = new AtomicBoolean(false);

        // 존재하면 데이터 수정
        data.stream()
                .filter(p -> id.equals(p.getId()))
                .findAny()
                .ifPresent(p -> {
                    p.setJob(person.getJob());
                    isPresent.set(true);
                });

        // 존재하지 않는 경우 데이터 추가
        if(!isPresent.get())
            data.add(person);
    }
}
