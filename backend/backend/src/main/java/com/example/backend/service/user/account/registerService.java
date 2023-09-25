package com.example.backend.service.user.account;

import java.util.Map;

public interface registerService {
    Map<String,String> register(String username, String password, String confirmpassword);
}
