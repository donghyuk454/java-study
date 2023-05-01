package main.java.com.dong.chap14.stream;

import main.java.com.dong.chap14.stream.controller.PersonController;
import main.java.com.dong.chap14.stream.controller.request.ChangeJobDto;
import main.java.com.dong.chap14.stream.controller.response.dto.PopularJobDto;
import main.java.com.dong.chap14.stream.entity.Person;
import main.java.com.dong.chap14.stream.enums.Job;
import main.java.com.dong.chap14.stream.repository.PersonRepository;
import main.java.com.dong.chap14.stream.repository.PersonRepositoryImpl;
import main.java.com.dong.chap14.stream.service.PersonService;
import main.java.com.dong.chap14.stream.util.DataManager;

import java.util.IntSummaryStatistics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chap14Application {

    private static final Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        PersonRepository personRepository = PersonRepositoryImpl.getInstance();
        PersonService personService = PersonService.getInstance(personRepository);
        PersonController personController = PersonController.getInstance(personService);

        // 모든 데이터 확인
        printMessage("모든 데이터", DataManager.getAllDataWithMap());

        // 내 ID 가져오기
        String myName = "이동혁";
        Long myId = (Long) personController
                .getIdByName("이동혁")
                .getBody();
        printMessage("내 이름", myName);
        printMessage("내 ID", myId);

        // 내 정보 가져오기
        Person myInfo = (Person) personController
                .getMyInformation(myId)
                .getBody();
        printMyInformation(myInfo);

        // 현재 마케터 리스트 가져오기
        String marketerList = (String) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

        // 내 직업을 마케터로 변경하기
        myInfo = (Person) personController
                .changeJob(new ChangeJobDto(myId, Job.MARKETER))
                .getBody();
        printMyInformation(myInfo);

        // 마케터 리스트 가져오기
        marketerList = (String) personController
                .getPersonNameListByJob(Job.MARKETER)
                .getBody();
        printMarketerList(marketerList);

        // 나이가 가장 많은 사람 정보 가져오기
        Person maxAgePerson = (Person) personController
                .getMaxAgePerson()
                .getBody();
        printMessage("나이 가장 많은 사람", maxAgePerson);

        // 나이에 대한 통계 정보 가져오기
        IntSummaryStatistics statistics = (IntSummaryStatistics) personController
                .getIntSummaryStatisticByAge()
                .getBody();
        printMessage("통계", statistics);

        // 가장 인기있는 직업과 수 가져오기
        PopularJobDto popularJobDto = (PopularJobDto) personController
                .getPopularJobAndCount()
                .getBody();
        printMessage("가장 인기있는 직업과 수", popularJobDto);
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
