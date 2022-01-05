package com.lquan.layui.service;

import com.lquan.layui.domain.Statement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Statement)表服务接口
 *
 * @author makejava
 * @since 2022-01-05 23:56:41
 */
public interface StatementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Statement queryById(Integer id);

    /**
     * 分页查询
     *
     * @param statement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Statement> queryByPage(Statement statement, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    Statement insert(Statement statement);
    
        /**
     * 新增数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    Statement insertSelective(Statement statement);

    /**
     * 修改数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    Statement update(Statement statement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    List<Statement> queryAllByBean(Statement statement);

}
