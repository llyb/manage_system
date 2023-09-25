package com.example.backend.controller.goods;

import com.example.backend.service.goods.AddGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddGoodsController {
    @Autowired
    private AddGoodsService addGoodsService;
    @PostMapping("/goods/add")
    public String addGoods(@RequestParam Map<String,String> map) {
        int good_number = Integer.parseInt(map.get("good_number"));
        String good_name = map.get("good_name");
        int good_num = Integer.parseInt(map.get("good_num"));
        int in_storage = Integer.parseInt(map.get("in_storage"));
        return addGoodsService.AddGoods(good_number, good_name, good_num, in_storage);
    }
}