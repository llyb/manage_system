package com.example.backend.mapper;

import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加一个用户
    public String adduser(String username, String password, String permision, String info) {
        String sql = "INSERT INTO user (username, password, permission, user_info) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{username, password, permision, info});
        return "add user success!";
    }

    // 更新某一用户的信息
    public String updateUser(int user_id, String username, String permission, String info) {
        String sql = "update user set username = ? , permission = ? , user_info = ? where id = ?";
        jdbcTemplate.update(sql, username, permission, info, user_id);
        return "success";
    }

    // 返回用户总数
    public String getCount() {
        String sql = "select count(*) from user";
        String count = jdbcTemplate.queryForObject(sql, String.class);
        return count;
    }

    // 删除用户
    public String deleteUser(int id) {
        String sql = "delete from manage.user where id = '?'";
        jdbcTemplate.update(sql, id);
        return "delete success";
    }

    // 返回所有用户
    public List<Map<String, Object>> queryAll() {
        String sql = "select * from user";
        System.out.println(jdbcTemplate);
        // 执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    // 查询某一特定用户
    public User get_id_User(int userId) {
        String sql = "select * from user where id = ?";
        //RowMapper对象用来构建结果集为User
        User user = jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPermission(rs.getString("permission"));
                user.setUser_info(rs.getString("user_info"));
                return user;
            }
        });

        return user;
    }

    // 通过姓名查询某一用户的信息
    public List<User> get_name_User(String name) {
        String sql = "select * from user where username = ?";
        //RowMapper对象用来构建结果集为User
        List<User> user = jdbcTemplate.query(sql, new Object[]{name}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPermission(rs.getString("permission"));
                user.setUser_info(rs.getString("user_info"));
                return user;
            }
        });

        return user;
    }
}
