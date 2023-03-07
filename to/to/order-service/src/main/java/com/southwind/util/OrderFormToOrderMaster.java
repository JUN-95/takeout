package com.southwind.util;

import com.southwind.entity.OrderMaster;
import com.southwind.form.OrderForm;

public class OrderFormToOrderMaster {

    public static OrderMaster transfor(OrderForm orderForm){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerPhone(orderForm.getPhone());
        orderMaster.setBuyerAddress(orderForm.getAddress());
        orderMaster.setBuyerOpenid(orderForm.getId());
        return orderMaster;
    }

}
