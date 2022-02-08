package com.lquan.service;

import com.lquan.domain.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 部门表(Dept)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 23:58:06
 */
public interface DeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dept queryById(Long id);

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Dept> queryByPage(Dept dept, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insert(Dept dept);
    
        /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insertSelective(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
