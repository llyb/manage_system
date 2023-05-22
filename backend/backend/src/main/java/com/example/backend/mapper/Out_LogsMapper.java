package com.example.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
@Repository
public class Out_LogsMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 对记录进行更新
    public String update_info(int goods_number, int storage_id, int user_id, int good_num) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String sql = "insert into out_table (goods_number, storage_id, time, user_id, good_num) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, goods_number, storage_id, format.format(date), user_id, good_num);
        return "success!";
    }
    // 获取所有的数据
    public List<Map<String, Object>> getAll_info() {
        String sql = "select * from out_table";
        // 执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}