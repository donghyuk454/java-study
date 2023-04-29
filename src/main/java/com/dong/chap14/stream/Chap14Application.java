package main.java.com.dong.chap14.stream;

import main.java.com.dong.chap14.stream.controller.PersonController;
import main.java.com.dong.chap14.stream.controller.request.ChangeJobDto;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.repository.PersonRepository;
import main.java.com.dong.chap14.stream.repository.PersonRepositoryImpl;
import main.java.com.dong.chap14.stream.service.PersonService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chap14Application {

    private static final Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        PersonRepository personRepository = PersonRepositoryImpl.getInstance();
        PersonService personService = PersonService.getInstance(personRepository);
        PersonController personController = PersonController.getInstance(personService);

        String myName = "이동혁";
        Long myId = (Long) personController
                .getIdByName("이동혁")
                .getBody();
        String result = String.format("My name : %s", myName);
        logger.log(Level.INFO, result);
        result = String.format("My id : %s", myId);
        logger.log(Level.INFO, result);

        Person myInfo = (Person) personController
                .getMyInformation(myId)
                .getBody();
        printMyInformation(myInfo);

        List marketerList = (List) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

        myInfo = (Person) personController
                .changeJob(new ChangeJobDto(myId, Job.MARKETER))
                .getBody();
        printMyInformation(myInfo);

        marketerList = (List) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

    }

    private static void printMyInformation (Person myInformation) {
        String result = String.format("My Information : %s", myInformation);
        logger.log(Level.INFO, result);
    }

    private static void printMarketerList (List marketerList) {
        String result = String.format("마케터 리스트 : %s", marketerList);
        logger.log(Level.INFO, result);
    }
}
