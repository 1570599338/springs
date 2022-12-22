package com.lquan.service;

import com.lquan.domain.Payment;


/**
 * (Payment)表服务接口
 *
 * @author lquan
 * @since 2022-12-22 19:44:24
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Long id);


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insert(Payment payment);
    
        /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insertSelective(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
