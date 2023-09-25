package com.example.backend.controller.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.user.account.registerService;

import java.util.Map;

@RestController
public class registerControlelr {
    @Autowired
    private registerService registerservice;

    @PostMapping("/user/account/register")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmedpassword = map.get("confirmedpassword");
        return registerservice.register(username, password, confirmedpassword);
    }
}
