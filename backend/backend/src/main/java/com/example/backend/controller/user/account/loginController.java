package com.example.backend.controller.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.user.account.loginService;
import java.util.Map;

@RestController
public class loginController {
    @Autowired
    private loginService loginservice; // 注入接口

    @PostMapping("user/account/token")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        // 从前端发送的请求中将数据取出来
        String username = map.get("username");
        String password = map.get("password");
        return loginservice.getToken(username, password);
    }
}