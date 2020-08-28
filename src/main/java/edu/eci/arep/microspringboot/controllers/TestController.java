package edu.eci.arep.microspringboot.controllers;

import edu.eci.arep.microspringboot.annotations.RequestMapping;

public class TestController {

    @RequestMapping("/SpringBoot")
    public static String index() {
        return "Greetings from Spring Boot!";
    }

}
