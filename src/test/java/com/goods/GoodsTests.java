package com.goods;

import com.goods.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsTests {
    @Autowired
    GoodsRepository goodsRepository;


    @Test
    public void test(){
        List goods = goodsRepository.findAll();

        System.out.println("list : " + goods);

//        return list;
    }
}
