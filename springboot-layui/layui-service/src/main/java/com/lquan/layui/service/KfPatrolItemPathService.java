package com.lquan.layui.service;


import com.lquan.layui.domain.KfPatrolItemPath;

import java.util.List;

/**
 * 检查项父子深度表(KfPatrolItemPath)表服务接口
 *
 * @author easycode
 * @since 2021-12-09 09:56:14
 */
public interface KfPatrolItemPathService {

    /**
     * 通过ID查询单条数据
     *
     * @param ancestor 主键
     * @return 实例对象
     */
    KfPatrolItemPath queryById(Integer ancestor);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<KfPatrolItemPath> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 实例对象
     */
    KfPatrolItemPath insert(KfPatrolItemPath kfPatrolItemPath);

    /**
     * 修改数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 实例对象
     */
    KfPatrolItemPath update(KfPatrolItemPath kfPatrolItemPath);

    /**
     * 通过主键删除数据
     *
     * @param ancestor 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ancestor);

}
