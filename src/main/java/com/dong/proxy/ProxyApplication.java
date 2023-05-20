package main.java.com.dong.proxy;

import main.java.com.dong.proxy.config.SampleConfig;
import main.java.com.dong.proxy.controller.SampleController;

public class ProxyApplication {

    public static void main(String[] args){
        SampleConfig sampleConfig = new SampleConfig();
        SampleController sampleController = sampleConfig.sampleController();

        try {
            sampleController.sampleMethod();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
