package com.example.exampleapp;

import com.example.EmbeddedAcmeService;
import com.example.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    EmbeddedAcmeService embeddedAcmeService;

    @Autowired
    MyService myService;

    @RequestMapping("theclass")
    public String theclass() {
        return embeddedAcmeService.hello();
    }

    @RequestMapping("thebean")
    public String thebean() {
        return myService.hello();
    }
}
