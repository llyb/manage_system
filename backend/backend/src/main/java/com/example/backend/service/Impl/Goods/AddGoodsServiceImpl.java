package com.example.backend.service.Impl.Goods;

import com.example.backend.mapper.GoodsMapper;
import com.example.backend.service.goods.AddGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddGoodsServiceImpl implements AddGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public String AddGoods(int goods_number, String goods_name, int goods_price) {
        return goodsMapper.addGoods(goods_number, goods_name, goods_price);
    }
}
