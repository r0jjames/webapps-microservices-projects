package com.project.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(path = "/hello-world")
    public String helloWord() {
        return "Hello World!!";
    }
    @GetMapping("sayHello")
    public String sayHello(){
        return "Hi SpringFramework!!!";
    }
    @GetMapping("sayHello2")
    public String sayHello2(){
        return "Hi SpringFramework!!! Hello 2";
    }
}
