package com.lquan.layui.service;

import com.kaishun.study.entity.KfPatrolItemInfo;

import java.util.List;

/**
 * 巡查检查项信息(KfPatrolItemInfo)表服务接口
 *
 * @author easycode
 * @since 2021-12-08 18:06:57
 */
public interface KfPatrolItemInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    KfPatrolItemInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<KfPatrolItemInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 实例对象
     */
    KfPatrolItemInfo insert(KfPatrolItemInfo kfPatrolItemInfo);

    /**
     * 修改数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 实例对象
     */
    KfPatrolItemInfo update(KfPatrolItemInfo kfPatrolItemInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
