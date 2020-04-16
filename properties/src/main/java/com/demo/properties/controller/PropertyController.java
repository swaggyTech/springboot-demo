package com.demo.properties.controller;

import cn.hutool.core.lang.Dict;
import com.demo.properties.property.ApplicationProperty;
import com.demo.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/16 12:13
 */
@RestController
public class PropertyController {

    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty,DeveloperProperty developerProperty){
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index(){
        return Dict.create().set("applicationProperty",applicationProperty).set("developerProperty",developerProperty);
    }
}
