package com.alix.product.service;


import com.alix.product.dto.CartDTO;
import com.alix.product.dataobjcet.ProductInfo;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();


    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 口库存
     * */
    void decreaseStock(List<CartDTO> cartDTOList);


}
