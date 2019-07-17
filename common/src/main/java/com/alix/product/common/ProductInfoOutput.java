package com.alix.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Alix
 * @date 2019-07-11 23:46
 */
@Data
public class ProductInfoOutput {

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;
}
