package main.java.com.dong.chap14.stream;

import main.java.com.dong.chap14.stream.controller.PersonController;
import main.java.com.dong.chap14.stream.controller.request.ChangeJobDto;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.repository.PersonRepository;
import main.java.com.dong.chap14.stream.repository.PersonRepositoryImpl;
import main.java.com.dong.chap14.stream.service.PersonService;
import main.java.com.dong.chap14.stream.util.DataManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chap14Application {

    private static final Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        PersonRepository personRepository = PersonRepositoryImpl.getInstance();
        PersonService personService = PersonService.getInstance(personRepository);
        PersonController personController = PersonController.getInstance(personService);

        printMessage("모든 데이터", DataManager.getAllDataWithMap());

        String myName = "이동혁";
        Long myId = (Long) personController
                .getIdByName("이동혁")
                .getBody();
        printMessage("내 이름", myName);
        printMessage("내 ID", myId);

        Person myInfo = (Person) personController
                .getMyInformation(myId)
                .getBody();
        printMyInformation(myInfo);

        String marketerList = (String) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

        myInfo = (Person) personController
                .changeJob(new ChangeJobDto(myId, Job.MARKETER))
                .getBody();
        printMyInformation(myInfo);

        marketerList = (String) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

        Person maxAgePerson = (Person) personController
                .getMaxAgePerson()
                .getBody();
        printMessage("나이 가장 많은 사람", maxAgePerson);
    }

    private static void printMyInformation (Person myInformation) {
        printMessage("내 정보", myInformation);
    }

    private static void printMarketerList (String marketerList) {
        printMessage("마케터 리스트", marketerList);
    }


    private static <T>void printMessage (String message, T obj) {
        message += " : %s";
        String result = String.format(message, obj.toString());
        logger.log(Level.INFO, result);
    }
}
