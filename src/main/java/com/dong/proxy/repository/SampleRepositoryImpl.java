package main.java.com.dong.proxy.repository;

public class SampleRepositoryImpl implements SampleRepository {

    @Override
    public void sampleMethod(String msg) throws Exception {
        System.out.println(msg);
        throw new Exception("exception message");
    }
}
