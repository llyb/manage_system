package com.example.backend.controller.user.account;

import com.example.backend.service.user.account.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;

@RestController
public class UpdateUserServiceController {
    @Autowired
    private UpdateUserService updateUserService;

    @PostMapping("/user/update")
    public Map<String, String> updateUser(@RequestParam Map<String, String> map) {
        int user_id = Integer.parseInt(map.get("user_id"));
        String username = map.get("username");
        String permission = map.get("permission");
        String user_info = map.get("user_info");

        return updateUserService.updateUser(user_id, username, permission, user_info);
    }
}