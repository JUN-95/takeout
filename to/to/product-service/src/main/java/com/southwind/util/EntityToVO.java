package com.southwind.util;

import com.southwind.entity.ProductInfo;
import com.southwind.vo.ProductInfoVO;

/**
 * 实体类转VO
 */
public class EntityToVO {

    /**
     * ProductInfo 转 ProductInfoVO
     */
    public static ProductInfoVO ProductInfoToProductInfoVO(ProductInfo productInfo){
        ProductInfoVO result = new ProductInfoVO();
        result.setId(productInfo.getProductId());
        result.setDecription(productInfo.getProductDescription());
        result.setName(productInfo.getProductName());
        result.setIcon(productInfo.getProductIcon());
        result.setPrice(productInfo.getProductPrice());
        result.setStock(productInfo.getProductStock());
        return result;
    }

}
