package com.lquan.layui.dao;


import com.lquan.layui.domain.KfPatrolItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡查检查项信息(KfPatrolItemInfo)表数据库访问层
 *

 */
@Mapper
public interface KfPatrolItemInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    KfPatrolItemInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<KfPatrolItemInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 对象列表
     */
    List<KfPatrolItemInfo> queryAll(KfPatrolItemInfo kfPatrolItemInfo);

    /**
     * 新增数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 影响行数
     */
    int insert(KfPatrolItemInfo kfPatrolItemInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<KfPatrolItemInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<KfPatrolItemInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<KfPatrolItemInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<KfPatrolItemInfo> entities);

    /**
     * 修改数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 影响行数
     */
    int update(KfPatrolItemInfo kfPatrolItemInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

