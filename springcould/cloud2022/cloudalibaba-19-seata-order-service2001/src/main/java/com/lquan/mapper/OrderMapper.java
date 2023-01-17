package com.lquan.mapper;


import com.lquan.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-17 02:29:28
 */
@Mapper 
public interface OrderMapper {

    /**
     * 修改订单状态，从零改为1
     * @param userId
     * @param status
     */
    void updateStatus(@Param("userId") Long userId,@Param("status") Integer status);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Long id);


    /**
     * 统计总行数
     *
     * @param order 查询条件
     * @return 总行数
     */
    long count(Order order);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int insert(Order order);
    
        /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int insertSelective(Order order);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Order> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Order> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Order> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Order> entities);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

