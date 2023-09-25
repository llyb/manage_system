package com.example.backend.service.user.account;

import java.util.Map;

public interface UpdateUserService {
    public Map<String,String> updateUser(int user_id, String username, String permission, String info);
}
