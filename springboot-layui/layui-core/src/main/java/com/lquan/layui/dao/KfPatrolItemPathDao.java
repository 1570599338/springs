package com.lquan.layui.dao;

import com.lquan.layui.domain.KfPatrolItemPath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 检查项父子深度表(KfPatrolItemPath)表数据库访问层
 *
 */
@Mapper
public interface KfPatrolItemPathDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ancestor 主键
     * @return 实例对象
     */
    KfPatrolItemPath queryById(Integer ancestor);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<KfPatrolItemPath> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param kfPatrolItemPath 实例对象
     * @return 对象列表
     */
    List<KfPatrolItemPath> queryAll(KfPatrolItemPath kfPatrolItemPath);

    /**
     * 新增数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 影响行数
     */
    int insert(KfPatrolItemPath kfPatrolItemPath);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<KfPatrolItemPath> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<KfPatrolItemPath> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<KfPatrolItemPath> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<KfPatrolItemPath> entities);

    /**
     * 修改数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 影响行数
     */
    int update(KfPatrolItemPath kfPatrolItemPath);

    /**
     * 通过主键删除数据
     *
     * @param ancestor 主键
     * @return 影响行数
     */
    int deleteById(Integer ancestor);

}

