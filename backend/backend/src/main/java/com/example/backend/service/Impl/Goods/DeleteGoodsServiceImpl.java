package com.example.backend.service.Impl.Goods;

import com.example.backend.mapper.GoodsMapper;
import com.example.backend.service.goods.DeleteGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteGoodsServiceImpl implements DeleteGoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public String delete(int goods_number) {
        return goodsMapper.deleteGoods(goods_number);
    }
}
