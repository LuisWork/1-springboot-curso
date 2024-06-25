package com.luis.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path="/details-rest", method =  RequestMethod.GET)

    @GetMapping("/details-rest")
    public Map<String, Object> detailsModel() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hello World Spring Boot");
        body.put("subtitle", "Pasando datos al JSON para RESTController");
        body.put("name", "Luis");
        body.put("lastname", "Zambrano");
        return body;
    }


    

}
