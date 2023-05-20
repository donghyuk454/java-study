package main.java.com.dong.proxy.config;

import main.java.com.dong.proxy.controller.SampleController;
import main.java.com.dong.proxy.controller.SampleControllerImpl;
import main.java.com.dong.proxy.log.LogTrace;
import main.java.com.dong.proxy.log.LogTraceHandler;
import main.java.com.dong.proxy.log.MyLogTrace;
import main.java.com.dong.proxy.repository.SampleRepository;
import main.java.com.dong.proxy.repository.SampleRepositoryImpl;
import main.java.com.dong.proxy.service.SampleService;
import main.java.com.dong.proxy.service.SampleServiceImpl;

import java.lang.reflect.Proxy;

public class SampleConfig {

    private static final LogTrace logTrace = new MyLogTrace();

    public SampleRepository sampleRepository() {
        SampleRepository sampleRepository = new SampleRepositoryImpl();

        return (SampleRepository) Proxy.newProxyInstance(SampleRepository.class.getClassLoader(),
                                new Class[]{SampleRepository.class},
                                new LogTraceHandler(logTrace, sampleRepository));
    }

    public SampleService sampleService() {
        SampleService sampleService = new SampleServiceImpl(sampleRepository());

        return (SampleService) Proxy.newProxyInstance(SampleService.class.getClassLoader(),
                new Class[]{SampleService.class},
                new LogTraceHandler(logTrace, sampleService));
    }

    public SampleController sampleController() {
        SampleController sampleController = new SampleControllerImpl(sampleService());

        return (SampleController) Proxy.newProxyInstance(SampleController.class.getClassLoader(),
                new Class[]{SampleController.class},
                new LogTraceHandler(logTrace, sampleController));
    }
}
