package com.southwind.controller;

import com.southwind.service.OrderMasterService;
import com.southwind.util.ResultVOUtil;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/order")
public class OrderMasterSellerController {
    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVOUtil.success(this.orderMasterService.getOrderByPage(page, size));
    }

    @PutMapping("/cancel/{orderId}")
    public ResultVO cancel(@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.handler("cancel", orderId);
        if(!result) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @PutMapping("/finish/{orderId}")
    public ResultVO finish(@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.handler("finish", orderId);
        if(!result) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}
