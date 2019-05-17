package com.polytech.polyNet.api;

import com.polytech.polyNet.application.RegisterService;
import com.polytech.polyNet.object.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final RegisterService registerService;

    @Autowired
    public LoginController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public void register(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam("passwordconf") String passwordconf) {
        if(password.equals(passwordconf)) {
            this.registerService.register(new Users(username, password));
        }
    }
}
