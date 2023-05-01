package main.java.com.dong.chap14.stream.controller;

import main.java.com.dong.chap14.stream.controller.request.ChangeJobDto;
import main.java.com.dong.chap14.stream.controller.response.BaseResponse;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

public class PersonController {

    private static PersonController personController;
    private final PersonService personService;

    private PersonController(PersonService personService) {
        this.personService = personService;
    }

    public static synchronized PersonController getInstance(PersonService personService) {
        if (personController == null) {
            personController = new PersonController(personService);
        }
        return personController;
    }

    public BaseResponse getMyInformation (final long id) {
        Person person = personService.findPersonById(id);

        return person != null ? BaseResponse.isOk(person, Person.class) : BaseResponse.isBadRequest("그런 사람 없어요!");
    }

    public BaseResponse changeJob (ChangeJobDto dto) {
        Person person = personService.changeJob(dto.getId(), dto.getJob());

        return person != null ? BaseResponse.isOk(person, Person.class) : BaseResponse.isBadRequest("그런 사람 없어요!");
    }

    public BaseResponse getPersonNameListByJob (Job job) {
        String nameList = personService.getPersonNameListByJob(job)
                        .stream()
                        .collect(Collectors.joining(","));

        return BaseResponse.isOk(nameList, String.class);
    }

    public BaseResponse getIdByName (String name) {
        return BaseResponse.isOk(personService.getIdByName(name), Long.class);
    }

    public BaseResponse getMaxAgePerson () {
        Person maxAgePerson = personService.getMaxAgePerson();
        return maxAgePerson != null ? BaseResponse.isOk(maxAgePerson, Person.class) : BaseResponse.isBadRequest("사람이 없어요!");
    }
}
