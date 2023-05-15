package com.goods.controller;

import com.goods.dto.GoodsDTO;
import com.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/list")
    public ResponseEntity<Page<GoodsDTO>> goodsList(
            @PageableDefault(page = 0, size = 10, sort = "no", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String productName
            ){
        Page<GoodsDTO> goodsList = goodsService.getGoodsList(pageable, productName);
        return ResponseEntity.ok(goodsList);
    }

    @PostMapping("/create")
    public ResponseEntity<GoodsDTO> createGoods(@RequestBody GoodsDTO goodsDTO) {
        GoodsDTO createdGoods = goodsService.createGoods(goodsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoods);
    }
}
