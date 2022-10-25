package com.rakesh.restfultest.simple_rest_api.Service;

import com.rakesh.restfultest.simple_rest_api.entity.Greeting;
import org.springframework.stereotype.Service;

@Service
public class SimpleRestfulService {
    public Greeting getSimpleRestApi() {
        return new Greeting("Welcome to spring boot");
    }
}
