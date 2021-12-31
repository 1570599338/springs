package com.lquan.layui.service;

import com.lquan.layui.domain.TbQuartzJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbQuartzJob)表服务接口
 *
 * @author lquan
 * @since 2021-12-31 11:30:15
 */
public interface TbQuartzJobService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbQuartzJob queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbQuartzJob 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbQuartzJob> queryByPage(TbQuartzJob tbQuartzJob, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    TbQuartzJob insert(TbQuartzJob tbQuartzJob);

        /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    int insertSelective(TbQuartzJob tbQuartzJob);

    /**
     * 修改数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    TbQuartzJob update(TbQuartzJob tbQuartzJob);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);

    /**
     * 查询定时任务
     * @param tbQuartzJob
     * @return
     */
    List<TbQuartzJob> queryQuartzJobList(TbQuartzJob tbQuartzJob);

    /**
     * 根据bean查询定时任务详情
     *
     * @param tbQuartzJob
     * @return
     */
    TbQuartzJob selectByBean(TbQuartzJob tbQuartzJob);

}
