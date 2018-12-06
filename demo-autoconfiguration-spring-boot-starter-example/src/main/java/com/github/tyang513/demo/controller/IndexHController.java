package com.github.tyang513.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tyang513.demo.service.DemoComplexService;
import com.github.tyang513.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tao.yang
 * @date 2018-11-30
 */
@Controller
@RequestMapping("/indexs")
public class IndexHController {

    private static final Logger logger = LoggerFactory.getLogger(IndexHController.class);

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoComplexService demoComplexService;

    @RequestMapping(value = "/s",method = RequestMethod.GET)
    @ResponseBody
    public String indexh(){
        String configureLocationn = demoService.getConfigurationLocation();
        logger.info(configureLocationn);
        return configureLocationn;
    }

    @RequestMapping(value = "/ss",method = RequestMethod.GET)
    @ResponseBody
    public String indexComplex() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(demoComplexService.getMap());
    }
}
