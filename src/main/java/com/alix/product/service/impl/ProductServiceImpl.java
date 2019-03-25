package com.alix.product.service.impl;


import com.alix.product.DTO.CartDTO;
import com.alix.product.dataobjcet.ProductInfo;
import com.alix.product.enums.ResultEnum;
import com.alix.product.exception.ProductException;
import com.alix.product.repository.ProductInfoRepository;
import com.alix.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by 廖师兄
 * 2017-12-09 21:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(com.alix.product.enums.ProductStatusEnum.UP.getCode());
    }

    /**
     * 查询商品列表
     * */
    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     * */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //检查是否有库存
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //检查库存是否充足
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

        }
    }


}
