package com.southwind.mapper;

import com.southwind.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 类目表 Mapper 接口
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    public String findNameByType(Integer type);
}
