package com.southwind.service;

import com.southwind.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.vo.ProductCategoryVO;
import com.southwind.vo.ResultVO;

import java.util.List;

/**
 * <p>
 * 类目表 服务类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public ResultVO<List<ProductCategoryVO>> voList();
    public List<ProductCategoryVO> getAllCategoryVO();
}
