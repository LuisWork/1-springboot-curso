package com.luis.curso.springboot.webapp.springboot_web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luis.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details-model")
    public String detailsModel(Model model) {
        model.addAttribute("title", "Hello World Spring Boot");
        model.addAttribute("subtitle", "Pasando datos a la vista con Model");
        model.addAttribute("name", "Luis");
        model.addAttribute("lastname", "Zambrano");
        return "details-model";
    }

    @GetMapping("/details-map")
    public String detailsMap(Map<String, Object> model) {
        model.put("title", "Hello World Spring Boot");
        model.put("subtitle", "Pasando datos a la vista con Map");
        model.put("name", "Luis");
        model.put("lastname", "Zambrano");
        return "details-map";
    }

    @GetMapping("/details-entity")
    public String detailsEntity(Model model) {
        User user = new User("Luis", "Zambrano");
        model.addAttribute("title", "Pasando un objeto a la vista Thymeleaf");
        model.addAttribute("user", user);
        return "details-entity";
    }

    @GetMapping("/details-conditional")
    public String detailsConditional(Model model) {
        model.addAttribute("title", "Hello World Spring Boot");
        model.addAttribute("subtitle", "Pasando datos a la vista con Model");
        model.addAttribute("name", "Luis");
        model.addAttribute("lastname", "Zambrano");
        model.addAttribute("email", "luis.correo.com");
        return "details-if-conditional";
    }

}
