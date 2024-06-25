package com.luis.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.webapp.springboot_web.models.User;
import com.luis.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import com.luis.curso.springboot.webapp.springboot_web.models.dto.UserDtoCustom;
import com.luis.curso.springboot.webapp.springboot_web.models.dto.UserDtoCustom2;

@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path="/details-rest", method =  RequestMethod.GET)

    @GetMapping("/list-users")
    public List<User> list() {
        User user = new User("Luis", "Zambrano");
        User pepe = new User("Pepe", "Pepo");
        User john = new User("John", "Doe");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(pepe);
        users.add(john);
        return users;
    }

    @GetMapping("/list-users-helper")
    public List<User> listHelper() {
        User user = new User("Luis", "Zambrano");
        User pepe = new User("Pepe", "Pepo");
        User john = new User("John", "Doe");
        List<User> users = Arrays.asList(user, pepe, john);
        return users;
    }

    @GetMapping("/details-rest")
    public Map<String, Object> detailsModel() {
        User user = new User("Luis", "Zambrano");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Pasando objeto al JSON");
        body.put("user", user);
        return body;
    }

    @GetMapping("/details-rest-dto")
    public UserDto detailsModelDto() {
        UserDto userDto = new UserDto();
        User user = new User("Luis", "Zambrano");
        userDto.setUser(user);
        userDto.setTitle("Usando DTO para formatear datos del POJO");
        return userDto;
    }

    @GetMapping("/details-rest-dto-custom")
    public UserDtoCustom detailsModelDtoCustom() {
        UserDtoCustom userDtoCustom = new UserDtoCustom();
        User user = new User("Luis", "Zambrano");
        userDtoCustom.setUser(user.getName());
        userDtoCustom.setLastname(user.getLastname());
        return userDtoCustom;
    }

    @GetMapping("/details-rest-dto-custom-2")
    public UserDtoCustom2 detailsModelDtoCustom2() {
        UserDtoCustom2 userDtoCustom2 = new UserDtoCustom2();
        User user = new User("Luis", "Zambrano");
        userDtoCustom2.setFullname(user.getName().concat(" ").concat(user.getLastname()));
        return userDtoCustom2;
    }


    

}
