package main.java.com.dong.chap14.stream.repository;

import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(long id);
    Person save(Person person);
    Optional<Person> findByMame(String name);
    List<Person> findByJob(Job job);
    Optional<Person> findMaxAgePerson();
}
