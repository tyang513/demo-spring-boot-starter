package com.github.tyang513.demo.springboot.autoconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author tao.yang
 * @date 2018-12-06
 */
@ConfigurationProperties(prefix = DemoComplexProperties.COMPLEX_PREFIX)
public class DemoComplexProperties {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(DemoComplexProperties.class);

    /**
     * 复杂对象
     */
    public final static String COMPLEX_PREFIX = "complex";

    private Map<String, ComplexEntity> boot;

    public Map<String, ComplexEntity> getBoot() {
        return boot;
    }

    public void setBoot(Map<String, ComplexEntity> boot) {
        this.boot = boot;
    }
}
