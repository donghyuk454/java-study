package main.java.com.dong.chap14.stream.service;

import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    private static PersonService personService;

    private final PersonRepository personRepository;

    private PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static PersonService getInstance(PersonRepository personRepository) {
        if (personService == null) {
            personService = new PersonService(personRepository);
        }
        return personService;
    }

    public Person findPersonById (Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    public Person changeJob (Long id, Job job) {
        Person person = personRepository.findById(id)
                .orElse(null);

        if (person == null)
            return null;

        person.setJob(job);

        return personRepository.save(person);
    }

    public List<String> getPersonNameListByJob (Job job) {
        List<Person> personList =
                personRepository.findByJob(job);

        return personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public Long getIdByName (String name) {
        Person person = personRepository.findByMame(name)
                .orElse(null);

        return person == null ? null : person.getId();
    }

    public Person getMaxAgePerson () {
        return personRepository.findMaxAgePerson()
                .orElse(null);
    }
}
