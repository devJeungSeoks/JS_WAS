package com.goods.service;

import com.goods.dto.GoodsDTO;
import com.goods.entity.Goods;
import com.goods.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    public Page<GoodsDTO> getGoodsList(Pageable pageable, String productName) {
        Page<Goods> goodsList = (productName.equals(null) || productName.equals("")) ? goodsRepository.findAll(pageable) : goodsRepository.findByProductNameContaining(pageable, productName);
        return mapGoodsListToDTO(goodsList);
    }

    private Page<GoodsDTO> mapGoodsListToDTO(Page<Goods> goodsList) {
        return goodsList.map(this::mapGoodsToDTO);
    }

    private GoodsDTO mapGoodsToDTO(Goods goods) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setContent(goods.getContent());
        goodsDTO.setProductName(goods.getProductName());
        goodsDTO.setKind(goods.getKind());
        goodsDTO.setPrice1(goods.getPrice1());
        goodsDTO.setPrice2(goods.getPrice2());
        goodsDTO.setPrice3(goods.getPrice3());
        goodsDTO.setContent(goods.getContent());
        goodsDTO.setImage(goods.getImage());
        goodsDTO.setUseYn(goods.getUseYn());

        return goodsDTO;
    }
}
