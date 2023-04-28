package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserMapper usermapper;
    @GetMapping("/seluser")
    public String getuser() {
        return usermapper.getCount();
    }

    @GetMapping("query")
    public List<Map<String, Object>> queryAll() {
        return usermapper.queryAll();
    }

    @GetMapping("/adduser")
    public String adduser() {
        return usermapper.adduser();
    }

    @GetMapping("/getuser/{id}")
    public User getuser(@PathVariable("id") int id) {
        return usermapper.getUser(id);
    }
}
