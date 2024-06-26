package com.luis.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.luis.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/param")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Mensaje por defecto", name = "mensaje") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDto bar(HttpServletRequest request) {
        Integer code = 10;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {}
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    

}
