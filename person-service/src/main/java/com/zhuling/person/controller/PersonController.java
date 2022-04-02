package com.zhuling.person.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {
    @GetMapping("detail")
    public String detail() {
        System.out.println("789");
        return "ok";
    }
}
