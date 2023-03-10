package com.southwind.mapper;

import com.southwind.entity.OrderMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {
    public int cancel(String buyerId,String orderId);
    public int finish(String orderId);
    public int pay(String buyerId,String orderId);
    public int handler(Integer status,String orderId);
}
