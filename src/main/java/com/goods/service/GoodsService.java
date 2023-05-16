package com.goods.service;

import com.goods.dto.GoodsDTO;
import com.goods.entity.Goods;
import com.goods.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    /**
     *
     * @param pageable
     * @param productName
     * @return
     */
    public Page<GoodsDTO> getGoodsList(Pageable pageable, String productName) {
        Page<Goods> goodsList = (productName.equals(null) || productName.equals("")) ?
                goodsRepository.findAll(pageable) : goodsRepository.findByProductNameContaining(pageable, productName);
        return mapGoodsListToDTO(goodsList);
    }

    /**
     *
     * @param goodsDTO
     * @return
     */
    public GoodsDTO createGoods(GoodsDTO goodsDTO) {
        Goods goods = mapDTOToGoods(goodsDTO);
        goods.setUseYn("Y");
        Goods savedGoods = goodsRepository.save(goods);
        return mapGoodsToDTO(savedGoods);
    }

    /**
     * 역할 : mapGoodsListToDTO 메소드는 Goods 객체들을 GoodsDTO 객체들로 매핑하여 페이지 단위로 반환하는 역할을 수행함
     * @param goodsList
     * @return
     */
    private Page<GoodsDTO> mapGoodsListToDTO(Page<Goods> goodsList) {
        return goodsList.map(this::mapGoodsToDTO);
    }

    private Goods mapDTOToGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        goods.setProductName(goodsDTO.getProductName());
        goods.setKind(goodsDTO.getKind());
        goods.setCostPrice(goodsDTO.getCostPrice());
        goods.setSalesPrice(goodsDTO.getSalesPrice());
        goods.setProfitPrice(goodsDTO.getProfitPrice());
        goods.setContent(goodsDTO.getContent());
        goods.setLimitedTimeOffer(goodsDTO.getLimitedTimeOffer());
        goods.setImage(goodsDTO.getImage());
        goods.setUseYn(goodsDTO.getUseYn());

        // 필요한 경우에 따라 추가 필드를 매핑할 수 있음
        return goods;
    }

    private GoodsDTO mapGoodsToDTO(Goods goods) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setContent(goods.getContent());
        goodsDTO.setLimitedTimeOffer(goods.getLimitedTimeOffer());
        goodsDTO.setProductName(goods.getProductName());
        goodsDTO.setKind(goods.getKind());
        goodsDTO.setCostPrice(goods.getCostPrice());
        goodsDTO.setSalesPrice(goods.getSalesPrice());
        goodsDTO.setProfitPrice(goods.getProfitPrice());
        goodsDTO.setImage(goods.getImage());
        goodsDTO.setUseYn(goods.getUseYn());


        return goodsDTO;
    }
}
