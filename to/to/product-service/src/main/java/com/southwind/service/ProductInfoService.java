package com.southwind.service;

import com.southwind.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.vo.PageVO;
import com.southwind.vo.ProductManageVO;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface ProductInfoService extends IService<ProductInfo> {
    public boolean subStock(Integer productId,Integer quantity);
    public PageVO<List<ProductManageVO>> findProductManageVOByPage(Integer page, Integer size);
    public ProductManageVO findById(Integer id);
    public boolean updateStatus(Integer id,Boolean status);
    public boolean updateProductManageVO(ProductManageVO productManageVO);
}
