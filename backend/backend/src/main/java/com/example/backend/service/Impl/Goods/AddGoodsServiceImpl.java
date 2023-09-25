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
    public String AddGoods(int good_number, String good_name, int good_num, int in_storage) {
        return goodsMapper.addGoods(good_number, good_name, good_num, in_storage);
    }
}
