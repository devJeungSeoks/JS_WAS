package com.goods;

import com.goods.controller.GoodsController;
import com.goods.dto.GoodsDTO;
import com.goods.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsTests {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsController goodsController;

    @Test
    public void test(){
        List goods = goodsRepository.findAll();
        System.out.println("list : " + goods);
    }
    @Test
    public void createTest(){

        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setContent("TEST");
        goodsDTO.setProductName("TEST");
        goodsDTO.setKind("1");
        goodsDTO.setCostPrice(20);
        goodsDTO.setSalesPrice(20);
        goodsDTO.setProfitPrice(20);
        goodsDTO.setContent("TEST입니다.");
        goodsDTO.setImage(null);
        goodsDTO.setUseYn("Y");
        System.out.println("goodsDTO : " + goodsDTO);
        goodsController.createGoods(goodsDTO);
    }
}
