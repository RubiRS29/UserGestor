package com.AppGestorUser.GestorUser.controllers;

import com.AppGestorUser.GestorUser.dao.IUserDao;
import com.AppGestorUser.GestorUser.models.Usuario;
import com.AppGestorUser.GestorUser.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private IUserDao userDao;

    //Token -- que se debera devoler en el json
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/login")
    public String login(@RequestBody Usuario user){
        Usuario loginUser = userDao.GetUserByEmailPassword(user);
        if (loginUser != null){
            return jwtUtil.create(String.valueOf(loginUser.getId()), loginUser.getEmail());
        }
        return "FAIL";
    }
}
