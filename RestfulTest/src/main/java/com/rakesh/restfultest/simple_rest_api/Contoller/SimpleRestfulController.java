package com.rakesh.restfultest.simple_rest_api.Contoller;

import com.rakesh.restfultest.simple_rest_api.Service.SimpleRestfulService;
import com.rakesh.restfultest.simple_rest_api.entity.Greeting;
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
