package com.southwind.service.impl;

import com.southwind.entity.OrderDetail;
import com.southwind.mapper.OrderDetailMapper;
import com.southwind.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
