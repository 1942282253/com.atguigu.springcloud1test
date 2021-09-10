package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayMentController {

    @Autowired
    private PayMentService payMentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = payMentService.addPayMent(payment);

        if(result > 0){
            return new CommonResult(200,"插入数据库成功,端口号是:"+port,result);
        }else{
            return new CommonResult(400,"插入数据库失败",null);
        }

    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getcomm(@PathVariable("id") Long id){
        Payment payment = payMentService.getPayMentById(id);

        if(payment != null){
            return new CommonResult(200,"查询数据库成功,端口号是:"+port,payment);
        }else{
            return new CommonResult(400,"查询数据库失败"+id,null);
        }

    }
    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> list = discoveryClient.getServices();
        for(String str : list){
            log.info("*************elment"+str);

        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance server : instances){
            log.info(server.getServiceId()+"\t"+server.getHost()+"\t"+server.getUri());
        }
        return this.discoveryClient;
    }

}
