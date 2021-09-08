package com.AppGestorUser.GestorUser.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user_dash")
    public String index(){
        return "prueba";
    }

}
