package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.ConsumerFeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignPaymentController {

    @Autowired
    private ConsumerFeignPaymentService consumerFeignPaymentService;

    @GetMapping("/consumer/feign/get/payment/{id}")
    public CommonResult<Payment> getPyament(@PathVariable("id") Long id){
        return consumerFeignPaymentService.getcomm(id);
    }
}
