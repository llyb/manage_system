package com.example.backend.service.Impl.Goods;

import com.example.backend.mapper.GoodsMapper;
import com.example.backend.service.goods.UpdateGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateGoodsImpl implements UpdateGoods {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public String update(int goods_number, String goods_name, int goods_price, int old_good_number) {
        Map<String,String> mp;
        if("success".equals(goodsMapper.updateGoods(goods_number, goods_name, goods_price, old_good_number))) {
            return "success";
        }
        return "error";
    }
}
