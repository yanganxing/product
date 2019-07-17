package com.alix.product.server.service;


import com.alix.product.common.DecreaseStockInput;
import com.alix.product.common.ProductInfoOutput;
import com.alix.product.server.dataobjcet.ProductInfo;

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


    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 口库存
     * */
    void decreaseStock(List<DecreaseStockInput> cartDTOList);


}
