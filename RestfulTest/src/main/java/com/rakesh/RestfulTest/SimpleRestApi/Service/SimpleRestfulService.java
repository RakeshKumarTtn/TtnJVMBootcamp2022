package com.rakesh.RestfulTest.SimpleRestApi.Service;

import com.rakesh.RestfulTest.entity.Greeting;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SimpleRestfulService {
    public Greeting getSimpleRestApi() {
        return new Greeting("Welcome to spring boot");
    }
}
