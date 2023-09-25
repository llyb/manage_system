package com.example.backend.service.goods;

import java.util.Map;

public interface UpdateGoods {
    public String update(int goods_number, String goods_name, int goods_num, int in_storage, int old_good_number);
}
