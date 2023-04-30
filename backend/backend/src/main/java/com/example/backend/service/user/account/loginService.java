package com.example.backend.service.user.account;

import java.util.Map;

public interface loginService {
    Map<String,String> getToken(String username, String password);
}
