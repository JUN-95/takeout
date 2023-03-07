package com.southwind.controller;


import com.southwind.entity.ProductInfo;
import com.southwind.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author southwind
 * @since 2020-08-20
 */
@RestController
@RequestMapping("//productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @PutMapping("/subStock/{id}/{quantity}")
    public boolean subStock(@PathVariable("id") Integer id,@PathVariable("quantity") Integer quantity){
        return this.productInfoService.subStock(id, quantity);
    }

}

