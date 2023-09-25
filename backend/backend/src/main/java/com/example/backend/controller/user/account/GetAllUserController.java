package com.example.backend.controller.user.account;

import com.example.backend.service.user.account.GetAllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllUserController {
    @Autowired
    private GetAllUserService getAllUserService; // 将当前接口进行注入

    @GetMapping("/getAll/users")
    public List<Map<String,Object>> queryAll() {
        return getAllUserService.queryAll();
    }
}