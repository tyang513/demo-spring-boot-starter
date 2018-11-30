package com.github.tyang513.demo.service;

/**
 * @author tao.yang
 * @date 2018-11-30
 */
public class DemoService {

    private String configurationLocation;

    public DemoService(){

    }

    public DemoService(String configurationLocation){
        this.configurationLocation = configurationLocation;
    }

    public String getConfigurationLocation() {
        return configurationLocation;
    }
}
