package com.example.backend.service.Impl.User;

import com.example.backend.mapper.UserMapper;
import com.example.backend.service.user.account.GetAllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetAllUserServiceImpl implements GetAllUserService {
    @Autowired
    UserMapper userMapper; // 得到用户的mapper
    @Override
    public List<Map<String, Object>> queryAll() {
        return userMapper.queryAll();
    }
}