package com.github.tyang513.demo.springboot.autoconfiguration;

import com.github.tyang513.demo.service.DemoComplexService;
import com.github.tyang513.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tao.yang
 * @date 2018-11-30
 */
@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties({DemoProperties.class, DemoComplexProperties.class})
public class DemoAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Autowired
    private DemoComplexProperties demoComplexProperties;

    @Bean
    @ConditionalOnMissingBean
    public DemoService getDemoService(DemoProperties demoProperties) {
        return new DemoService(demoProperties.getConfigLocation());
    }

    @Bean
    @ConditionalOnMissingBean
    public DemoComplexService getDemoComplexService(DemoComplexProperties demoComplexProperties) {

        Map<String, Map<String, Object>> map = new HashMap<>();

        for (Map.Entry<String, ComplexEntity> entry : demoComplexProperties.getBoot().entrySet()){
            String key = entry.getKey();
            ComplexEntity value = entry.getValue();
            Map<String, Object> valueMap = map.get(key);
            if (valueMap == null){
                valueMap = new HashMap<>();
            }
            valueMap.put("name", value.getName());
            valueMap.put("key", value.getKey());
            valueMap.put("value", value.getValue());
            map.put(key, valueMap);
        }
        return new DemoComplexService(map);
    }

    public DemoComplexProperties getDemoComplexProperties() {
        return demoComplexProperties;
    }

    public void setDemoComplexProperties(DemoComplexProperties demoComplexProperties) {
        this.demoComplexProperties = demoComplexProperties;
    }

    public DemoProperties getDemoProperties() {
        return demoProperties;
    }

    public void setDemoProperties(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }
}
