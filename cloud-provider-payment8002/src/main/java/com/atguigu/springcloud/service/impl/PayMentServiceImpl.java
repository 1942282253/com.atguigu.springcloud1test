package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayMentServiceImpl implements PayMentService {

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int addPayMent(Payment payment) {

        return paymentDao.addPayMent(payment);
    }

    @Override
    public Payment getPayMentById(Long id) {
        return paymentDao.getPayMentById(id);
    }
}
