package com.rdp.template.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author 10011531
 */
@Controller
public class MvcTestController {

    @GetMapping(value = "/MvcTest/thymeleaf")
    public String thymeleaf() {
        return "testThymeleaf";
    }
}