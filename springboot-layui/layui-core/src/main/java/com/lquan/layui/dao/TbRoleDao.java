package com.lquan.layui.dao;

import com.lquan.layui.domain.TbRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbRole)表数据库访问层
 *
 */
@Mapper
public interface TbRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRole queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbRole 实例对象
     * @return 对象列表
     */
    List<TbRole> queryAll(TbRole tbRole);

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int insert(TbRole tbRole);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int update(TbRole tbRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<TbRole> findAll();
}