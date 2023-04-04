package test.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute(attributeName:"data", attributeValue:"hello!!");
        return "hello";

    }
}
