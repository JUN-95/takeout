package com.southwind.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("product-service")
public interface ProductFeign {

    @PutMapping("/productInfo/subStock/{id}/{quantity}")
    public boolean subStock(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity);
}
