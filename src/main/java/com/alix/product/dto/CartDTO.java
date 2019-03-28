package com.alix.product.dto;

import lombok.Data;

/**
 * @author Alix
 * @date 2019-03-21 22:12
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     * */
    private String productId;


    /**
     * 商品数量
     * */
    private Integer productQuantity;


    public CartDTO(){

    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
