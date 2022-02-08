package com.lquan.service;

import com.lquan.domain.Config;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 参数配置表(Config)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 23:56:39
 */
public interface ConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Integer id);

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Config> queryByPage(Config config, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config insert(Config config);
    
        /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config insertSelective(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
