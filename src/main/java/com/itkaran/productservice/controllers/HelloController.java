package com.itkaran.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // GET Hello Say

    @GetMapping("/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times) {

        String answer = "<h1>";
        answer += "Hi " + name + "!";
        //answer += "</h1>";

        for (int i=0; i<times; ++i) {
            answer += "</br>";
            answer += "Hello " + name + "-" + (i+1) + "!";
        }

       return answer;
    }
}
