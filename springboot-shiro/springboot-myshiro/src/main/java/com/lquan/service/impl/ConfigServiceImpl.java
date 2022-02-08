package com.lquan.service.impl;

import com.lquan.domain.Config;
import com.lquan.mapper.ConfigMapper;
import com.lquan.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 参数配置表(Config)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 23:56:39
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigMapper configMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(Integer id) {
        return this.configMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Config> queryByPage(Config config, PageRequest pageRequest) {
        long total = this.configMapper.count(config);
        return new PageImpl<>(this.configMapper.queryAllByLimit(config, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configMapper.insert(config);
        return config;
    }
    
    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insertSelective(Config config) {
        this.configMapper.insertSelective(config);
        return config;
    }
    

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configMapper.update(config);
        return this.queryById(config.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.configMapper.deleteById(id) > 0;
    }
}
