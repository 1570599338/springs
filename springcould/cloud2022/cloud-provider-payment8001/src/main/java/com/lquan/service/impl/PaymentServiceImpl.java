package com.lquan.service.impl;

import com.lquan.domain.Payment;
import com.lquan.dao.PaymentMapper;
import com.lquan.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Payment)表服务实现类
 *
 * @author lquan
 * @since 2022-12-22 19:44:25
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Long id) {
        return this.paymentMapper.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        this.paymentMapper.insert(payment);
        return payment;
    }
    
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insertSelective(Payment payment) {
        this.paymentMapper.insertSelective(payment);
        return payment;
    }
    

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        this.paymentMapper.update(payment);
        return this.queryById(payment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.paymentMapper.deleteById(id) > 0;
    }
}
