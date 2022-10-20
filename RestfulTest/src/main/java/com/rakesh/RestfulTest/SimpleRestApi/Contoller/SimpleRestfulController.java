package com.rakesh.RestfulTest.SimpleRestApi.Contoller;

import com.rakesh.RestfulTest.SimpleRestApi.Service.SimpleRestfulService;
import com.rakesh.RestfulTest.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestfulController {

    @Autowired
    SimpleRestfulService simpleRestfulService;

    public SimpleRestfulController(SimpleRestfulService simpleRestfulService) {
        this.simpleRestfulService = simpleRestfulService;
    }

    @RequestMapping("/greet")
    public Greeting getSimpleRestApi() {
        return simpleRestfulService.getSimpleRestApi();
    }

}
