package com.example.backend.controller.goods;

import com.example.backend.service.goods.DeleteGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteGoodsController {
    @Autowired
    private DeleteGoodsService deleteGoodsService;
    @DeleteMapping("/delete/goods")
    public String delete(@RequestParam String goods_number) {
        int number = Integer.parseInt(goods_number);
        return deleteGoodsService.delete(number);
    }
}