package com.southwind.controller;

import com.southwind.service.ProductCategoryService;
import com.southwind.vo.ProductCategoryVO;
import com.southwind.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 类目表 前端控制器
 * </p>
 *
 * @author southwind
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class ProductCategoryBuyerController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/list")
    public ResultVO<List<ProductCategoryVO>> list(){
        log.info("调用了{}端口的服务", this.port);
        return this.productCategoryService.voList();
    }

}

