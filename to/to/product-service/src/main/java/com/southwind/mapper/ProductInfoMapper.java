package com.southwind.mapper;

import com.southwind.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    public int updateStatus(Integer id,Integer status);
}
