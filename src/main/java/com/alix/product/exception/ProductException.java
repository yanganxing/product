package com.alix.product.exception;

import com.alix.product.enums.ResultEnum;

/**
 * @author Alix
 * @date 2019-03-21 22:25
 */
public class ProductException extends RuntimeException{

    private  Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
