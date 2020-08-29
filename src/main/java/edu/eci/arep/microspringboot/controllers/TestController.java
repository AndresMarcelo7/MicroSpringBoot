package edu.eci.arep.microspringboot.controllers;

import edu.eci.arep.microspringboot.annotations.RequestMapping;

public class TestController {

    @RequestMapping("/SpringBoot")
    public static String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/Pi")
    public static String pi() {
        return "Pi = "+  Math.PI;
    }

    @RequestMapping("/webapp")
    public static String webapp() {
        String line = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Mi página usando anotaciones con Spring Boot :D</h1>\n"
                + "</body>\n"
                + "</html>\n";
        return line;
    }

}
