package com.lquan.mapper;

import com.lquan.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * orderMapper接口
 * 
 * @author lquan
 * @date 2023-01-16 21:58:30
 */
@Mapper
public interface OrderMapper{
    /**
     * 查询Order
     * 
     * @param id
     * @return order
     */
    public Order selectOrderById(Long id);

    /**
     * 查询Order列表
     * 
     * @param order
     * @return order集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增Order
     * 
     * @param order
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改Order
     * 
     * @param order
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除Order
     * 
     * @param id
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除Order
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderByIds(String[] ids);
}

