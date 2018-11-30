package com.github.tyang513.demo.springboot.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tao.yang
 * @date 2018-11-30
 */
@ConfigurationProperties(prefix = DemoProperties.DEMO_PREFIX)
public class DemoProperties {

    public static final String DEMO_PREFIX="demo";

    /**
     * 配置路径
     */
    private String configLocation;

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
}
