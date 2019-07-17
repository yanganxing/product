package com.alix.product.common;

import lombok.Data;

/**
 * @author Alix
 * @date 2019-07-11 23:54
 */
@Data
public class DecreaseStockInput {


    /**
     * 商品ID
     * */
    private String productId;


    /**
     * 商品数量
     * */
    private Integer productQuantity;

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
