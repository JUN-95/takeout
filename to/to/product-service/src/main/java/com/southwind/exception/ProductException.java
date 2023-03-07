package com.southwind.exception;

import com.southwind.enums.ProductEnum;

public class ProductException extends RuntimeException {
    public ProductException(ProductEnum productEnum) {
        super(productEnum.getMsg());
    }
}
