package com.alix.product.DTO;

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
}
