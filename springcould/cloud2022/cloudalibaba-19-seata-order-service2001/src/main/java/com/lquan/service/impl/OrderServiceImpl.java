package com.lquan.service.impl;

import com.lquan.domain.Order;
import com.lquan.mapper.OrderMapper;
import com.lquan.service.AccountService;
import com.lquan.service.OrderService;
import com.lquan.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2023-01-17 02:29:31
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    /**
     * 创建订单
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp_create_group",rollbackFor = Exception.class)
    public void create(Order order) {
     //   创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
        String xid = RootContext.getXID();
        System.out.println("**************************order-->xid"+xid);
        // 创建订单
        log.info("----->开始新建订单");
        //新建订单
        order.setStatus(0);
        orderMapper.insertSelective(order);
        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");


        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.updateStatus(order.getUserId(),0);
       // orderMapper.update()
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");

    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long id) {
        return this.orderMapper.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderMapper.insert(order);
        return order;
    }
    
    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insertSelective(Order order) {
        this.orderMapper.insertSelective(order);
        return order;
    }
    

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderMapper.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderMapper.deleteById(id) > 0;
    }
}
