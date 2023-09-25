package com.example.backend.controller.goods;

import com.example.backend.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllGoodsController {
    @Autowired
    private GoodsMapper goodsMapper;
    @GetMapping("/get/goods")
    public List<Map<String,Object>> queryAll() {
        return goodsMapper.queryAll();
    }
}
