package com.example.backend.service.Impl.User;

import com.example.backend.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailesImpl implements UserDetails {
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // 账号是否过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 是否被锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 授权是否过期
        return true; // 没有过期
    }

    @Override
    public boolean isEnabled() { // 是启用的
        return true;
    }
}
