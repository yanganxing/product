package com.alix.product.server.controller;

import com.alix.product.common.DecreaseStockInput;
import com.alix.product.common.ProductInfoOutput;
import com.alix.product.server.dataobjcet.ProductCategory;
import com.alix.product.server.dataobjcet.ProductInfo;
import com.alix.product.server.service.CategoryService;
import com.alix.product.server.service.ProductService;
import com.alix.product.server.utils.ResultVOUtil;
import com.alix.product.server.vo.ProductInfoVO;
import com.alix.product.server.vo.ProductVO;
import com.alix.product.server.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alix
 * @date 2019-03-05 10:37
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     *
     * */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
    * 获取商品列表给订单服务使用
    * */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    private void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList){
       productService.decreaseStock(cartDTOList);
    }
}
