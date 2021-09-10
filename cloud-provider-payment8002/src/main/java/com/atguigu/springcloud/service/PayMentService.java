package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayMentService {
    public int addPayMent(Payment payment) ;

    public Payment getPayMentById(@Param("id") Long id);
}
