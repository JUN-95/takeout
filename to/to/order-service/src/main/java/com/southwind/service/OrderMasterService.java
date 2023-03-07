package com.southwind.service;

import com.southwind.entity.OrderMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.form.OrderForm;
import com.southwind.vo.OrderVO;
import com.southwind.vo.PageVO;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
public interface OrderMasterService extends IService<OrderMaster> {
    public String create(OrderForm orderForm);
    public List<OrderVO> getVOListByBuyerId(String buyerId, Integer current, Integer size);
    public OrderVO getVOByBuyerIdAndOrderId(String buyerId,String orderId);
    public boolean cancel(String buyerId,String orderId);
    public boolean finish(String orderId);
    public boolean pay(String buyerId,String orderId);
    public PageVO<List<OrderMaster>> getOrderByPage(Integer page, Integer size);
    public boolean handler(String type,String orderId);
}
