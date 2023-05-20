package main.java.com.dong.proxy.service;

import main.java.com.dong.proxy.repository.SampleRepository;

public class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }
    @Override
    public void sampleMethod () throws Exception {
        sampleRepository.sampleMethod("sample message");
    }
}
