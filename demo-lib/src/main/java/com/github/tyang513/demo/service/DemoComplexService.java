package com.github.tyang513.demo.service;

import java.util.Map;

/**
 * @author tao.yang
 * @date 2018-12-06
 */
public class DemoComplexService {

    Map<String, Map<String, Object>> map;

    public DemoComplexService(Map<String, Map<String, Object>> map) {
        this.map = map;
    }

    public Map<String, Map<String, Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, Object>> map) {
        this.map = map;
    }
}
