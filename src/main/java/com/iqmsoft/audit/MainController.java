package com.iqmsoft.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService appService;
    
    @GetMapping("/{arg1}")
    public String getResource(@PathVariable("arg1") String arg1) {
        return appService.myService1(arg1);
    }

    @GetMapping("/{arg1}/{arg2}")
    public String getResource(@PathVariable("arg1") String arg1, @PathVariable("arg2") String arg2) {
        return appService.myService2(arg1, arg2);
    }
}
