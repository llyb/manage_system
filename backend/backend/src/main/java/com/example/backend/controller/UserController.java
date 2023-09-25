package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @GetMapping("/adduser/{username}/{password}/{perssmision}/{info}")
    public String adduser(@PathVariable String username,
                          @PathVariable String password,
                          @PathVariable String perssmision,
                          @PathVariable String info) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(password);
        return usermapper.adduser(username, password, perssmision, info);
    }

    @GetMapping("/getuserId/{id}")
    public User get_id_user(@PathVariable("id") int id) {
        return usermapper.get_id_User(id);
    }

    @GetMapping("/getuserName/{name}")
    public List<User> get_name_user(@PathVariable("name") String name) {
        return usermapper.get_name_User(name);
    }
}