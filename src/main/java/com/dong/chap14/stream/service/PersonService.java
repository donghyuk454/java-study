package main.java.com.dong.chap14.stream.service;

public class PersonService {

    private PersonService() {}

    private static class PersonServiceHolder {
        private static final PersonService INSTANCE = new PersonService();
    }

    public static PersonService getInstance() {
        return PersonServiceHolder.INSTANCE;
    }

}
