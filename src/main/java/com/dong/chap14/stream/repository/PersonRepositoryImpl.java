package main.java.com.dong.chap14.stream.repository;

import main.java.com.dong.chap14.stream.DataManager;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;

import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl implements PersonRepository {

    private List<Person> entities;

    private PersonRepositoryImpl(List<Person> entities) {
        this.entities = entities;
    }

    private static class PersonRepositoryHolder {
        private static final PersonRepositoryImpl INSTANCE = new PersonRepositoryImpl(DataManager.getData());
    }

    public static PersonRepositoryImpl getInstance() {
        return PersonRepositoryHolder.INSTANCE;
    }

    @Override
    public Optional<Person> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Optional<Person> findByMame(String name) {
        return Optional.empty();
    }

    @Override
    public List<Person> findByJob(Job job) {
        return null;
    }

    @Override
    public Optional<Person> findMaxAgePerson() {
        return Optional.empty();
    }


}
