package com.example.backend.controller.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.user.account.infoService;

import java.util.Map;

@RestController
public class infoServiceController {
    @Autowired
    private infoService infoservice;

    @GetMapping("/user/account/info")
    public Map<String, String> getinfo() {
        return infoservice.getinfo();
    }
}
