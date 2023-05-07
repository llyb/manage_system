package com.example.backend.service.goods;

import java.util.Map;

public interface UpdateGoods {
    public String update(int goods_number, String goods_name, int goods_price, int old_good_number);
}
