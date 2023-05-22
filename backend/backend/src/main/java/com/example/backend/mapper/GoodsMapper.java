package com.example.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GoodsMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 返回所有商品信息
    public List<Map<String,Object>> queryAll() {
        String sql = "select * from goods";
        // 执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    // 更新商品信息
    public String updateGoods(int goods_number, String goods_name, int goods_num, int in_storage,int old_goods_number) {
        String sql = "update goods set goods_number = ? , goods_name = ? , goods_num = ?, in_storage = ? where goods_number = ?";
        jdbcTemplate.update(sql, goods_number, goods_name, goods_num, in_storage, old_goods_number);
        return "success";
    }

    // 删除特定的商品
    public String deleteGoods(int goods_number) {
        String sql = "delete from goods where goods_number = ?";
        jdbcTemplate.update(sql, goods_number);
        return "success";
    }

    // 插入商品
    public String addGoods(int goods_number, String goods_name, int goods_num, int in_storage) {
        String sql = "insert into goods values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{goods_number, goods_name, goods_num, in_storage});
        return "success";
    }
}