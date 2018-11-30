package com.github.tyang513.demo.springboot.autoconfiguration;

import com.github.tyang513.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tao.yang
 * @date 2018-11-30
 */
@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    public DemoProperties getDemoProperties() {
        return demoProperties;
    }

    public void setDemoProperties(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public DemoService getDemoService(DemoProperties demoProperties) {
        return new DemoService(demoProperties.getConfigLocation());
    }


}
