package main.java.com.dong.chap14.stream.repository;

import main.java.com.dong.chap14.stream.util.DataManager;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Person> findAll() {
        return entities;
    }

    @Override
    public Optional<Person> findById(long id) {
        return entities.stream()
                .filter(p->p.getId().equals(id))
                .findAny();
    }

    @Override
    public synchronized Person save(Person person) {
        // person 을 추가하거나 수정한 뒤 entities 수정
        entities = DataManager.persist(person);
        return person;
    }

    @Override
    public Optional<Person> findByMame(String name) {
        return entities.stream()
                .filter(p -> p.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Person> findByJob(Job job) {
        return entities.stream()
                .filter(p -> p.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findMaxAgePerson() {
        return entities.stream()
                .max(Comparator.comparingInt(Person::getAge));
    }

    @Override
    public Map<Job, Long> findPopularJob() {
        return entities.stream()
                .collect(
                        Collectors.groupingBy(Person::getJob, Collectors.counting())
                );
    }
}