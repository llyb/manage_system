package com.example.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StorageMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有仓库的信息
    public List<Map<String,Object>> queryAll() {
        String sql = "select * from storage";
        // 执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    public String updateToStore(int s_volume, int s_id) {
        String sql = "update storage set s_volume = s_volume - ? where s_id = ?";
        // 执行sql语句
        jdbcTemplate.update(sql, s_volume, s_id);
        return "success";
    }
}
