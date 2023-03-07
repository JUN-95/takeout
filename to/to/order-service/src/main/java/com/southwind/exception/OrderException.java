package com.southwind.exception;

import com.southwind.enums.OrderEnum;

public class OrderException extends RuntimeException {

    public OrderException(OrderEnum orderEnum) {
        super(orderEnum.getMsg());
    }
}
