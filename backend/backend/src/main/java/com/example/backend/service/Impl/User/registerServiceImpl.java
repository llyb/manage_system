package com.example.backend.service.Impl.User;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.account.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class registerServiceImpl implements registerService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmpassword) {
        Map<String,String> map = new HashMap<>();
        if(username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if(password == null || confirmpassword == null) {
            map.put("error_message", "密码不能为空");
        }

        username.trim();
        if(username.length() == 0) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if(username.length() > 100) {
            map.put("error_message", "密码长度不能太长");
            return map;
        }
        if(username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }
        if(!password.equals(confirmpassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }
        List<User> list = userMapper.get_name_User(username);
        if(!list.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedpassword = passwordEncoder.encode(password);
        userMapper.adduser(username, encodedpassword, "1", null);

        map.put("error_message", "success");

        return map;
    }
}
