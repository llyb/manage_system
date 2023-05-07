package com.example.backend.service.Impl.User;

import com.example.backend.mapper.UserMapper;
import com.example.backend.service.user.account.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, String> delete(int id) {
        Map<String,String> mp = new HashMap<>();
        if("delete success".equals(userMapper.deleteUser(id))) {
            mp.put("error_message", "success");
            return mp;
        }
        mp.put("errorr_message", "error");
        return mp;
    }
}
