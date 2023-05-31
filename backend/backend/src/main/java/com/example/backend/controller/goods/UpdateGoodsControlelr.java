package com.example.backend.controller.goods;

import com.example.backend.service.goods.UpdateGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateGoodsControlelr {
    @Autowired
    private UpdateGoods updateGoods;
    @PostMapping("/update/goods")
    public String Updategoods(@RequestParam Map<String,String> mp) {
        int goods_number = Integer.parseInt(mp.get("goods_number"));
        String goods_name = mp.get("goods_name");
        int goods_num = Integer.parseInt(mp.get("goods_num"));
        int old_good_number = Integer.parseInt(mp.get("old_good_number"));
        int in_storage = Integer.parseInt(mp.get("storage_id"));
        return updateGoods.update(goods_number, goods_name, goods_num, in_storage, old_good_number);
    }
}