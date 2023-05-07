package com.example.backend.service.Impl.User;

import com.example.backend.mapper.UserMapper;
import com.example.backend.service.user.account.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Map<String,String> updateUser(int user_id, String username, String permission, String info) {
        Map<String,String> map = new HashMap<>();
        if("success".equals(userMapper.updateUser(user_id, username, permission, info))) {
            map.put("error_message", "success");
            return map;
        }
        map.put("error_message", "error");
        return map;
    }
}
