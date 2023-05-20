package main.java.com.dong.proxy.controller;

import main.java.com.dong.proxy.service.SampleService;

public class SampleControllerImpl implements SampleController {

    private final SampleService sampleService;

    public SampleControllerImpl(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public void sampleMethod () throws Exception {
        sampleService.sampleMethod();
    }
}