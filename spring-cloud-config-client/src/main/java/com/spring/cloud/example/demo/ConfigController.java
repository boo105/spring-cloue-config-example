package com.spring.cloud.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private final StaticConfigService configStaticService;
    private final DynamicConfigService configDynamicService;

    @Autowired
    public ConfigController(StaticConfigService configStaticService, DynamicConfigService configDynamicService) {
        this.configStaticService = configStaticService;
        this.configDynamicService = configDynamicService;
    }

    @GetMapping(value = "/static")
    public Object getConfigFromStatic() {
        return configStaticService.getConfig();
    }

    @GetMapping(value = "/dynamic")
    public Object getConfigFromDynamic() {
        return configDynamicService.getConfig();

    }
}
