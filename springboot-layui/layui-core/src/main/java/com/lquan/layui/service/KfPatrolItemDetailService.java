package com.lquan.layui.service;

import com.kaishun.study.entity.KfPatrolItemDetail;

import java.util.List;

/**
 * 检查点详情信息(KfPatrolItemDetail)表服务接口
 *
 * @author easycode
 * @since 2021-12-08 18:07:13
 */
public interface KfPatrolItemDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    KfPatrolItemDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<KfPatrolItemDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param kfPatrolItemDetail 实例对象
     * @return 实例对象
     */
    KfPatrolItemDetail insert(KfPatrolItemDetail kfPatrolItemDetail);

    /**
     * 修改数据
     *
     * @param kfPatrolItemDetail 实例对象
     * @return 实例对象
     */
    KfPatrolItemDetail update(KfPatrolItemDetail kfPatrolItemDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
