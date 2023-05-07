package com.example.backend.controller.user.account;

import com.example.backend.service.Impl.User.DeleteUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeleteUserController {
    @Autowired
    DeleteUserServiceImpl deleteUserService;

    @DeleteMapping("/delete/user")
    public Map<String,String> delete(@RequestParam int id) {
        return deleteUserService.delete(id);
    }
}
