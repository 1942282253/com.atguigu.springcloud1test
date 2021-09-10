package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    public int addPayMent(Payment payment) ;

    public Payment getPayMentById(@Param("id") Long id);
}
