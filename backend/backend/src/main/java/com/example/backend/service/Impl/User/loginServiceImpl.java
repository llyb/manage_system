package com.example.backend.service.Impl.User;

import com.example.backend.pojo.User;
import com.example.backend.service.user.account.loginService;
import com.example.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public Map<String, String> getToken(String username, String password) {
        // 将账号和密码进行封装
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        //进行验证,如果登录失败会自动处理
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //将用户信息取出来
        UserDetailesImpl loginuser = (UserDetailesImpl) authenticate.getPrincipal();
        User user = loginuser.getUser();

        // 将用户id封装成一个jwttoken用来标识用户
        String jwt = JwtUtil.createJWT(user.getId().toString());

        // 登录成功! 返回信息和token
        Map<String,String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        return map;
    }
}