package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, @RequestParam String friend) {
        return "Hello and goodbye, " + name + "!" + " Hello " + friend;
    }

//    Handles requests of form /hello?name=LaunchCode
//    @GetMapping("hello")
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

//    Handles requests of form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<label for='name'>Name:</label>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<label for='friends name'>Friend's Name:</label>" +
                "<input type='text' label='friends name' name='friend'>" +
                "<input type='submit' value='Greet me!'> " +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
