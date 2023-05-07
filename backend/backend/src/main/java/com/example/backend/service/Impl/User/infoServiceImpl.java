package com.example.backend.service.Impl.User;

import com.example.backend.pojo.User;
import com.example.backend.service.user.account.infoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class infoServiceImpl implements infoService {
    @Override
    public Map<String, String> getinfo() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailesImpl loginUser = (UserDetailesImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        map.put("permission", user.getPermission());
        map.put("user_info", user.getUser_info());

        return map;
    }
}