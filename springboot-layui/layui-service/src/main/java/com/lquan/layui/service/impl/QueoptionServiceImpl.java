package com.lquan.layui.service.impl;

import com.lquan.layui.domain.Queoption;
import com.lquan.layui.dao.QueoptionMapper;
import com.lquan.layui.service.QueoptionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Queoption)表服务实现类
 *
 * @author makejava
 * @since 2022-01-05 23:55:32
 */
@Service
public class QueoptionServiceImpl implements QueoptionService {
    @Resource
    private QueoptionMapper queoptionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Queoption queryById(Integer id) {
        return this.queoptionMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param queoption 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Queoption> queryByPage(Queoption queoption, PageRequest pageRequest) {
        long total = this.queoptionMapper.count(queoption);
        return new PageImpl<>(this.queoptionMapper.queryAllByLimit(queoption, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    @Override
    public Queoption insert(Queoption queoption) {
        this.queoptionMapper.insert(queoption);
        return queoption;
    }
    
    /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    @Override
    public Queoption insertSelective(Queoption queoption) {
        this.queoptionMapper.insertSelective(queoption);
        return queoption;
    }
    

    /**
     * 修改数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    @Override
    public Queoption update(Queoption queoption) {
        this.queoptionMapper.update(queoption);
        return this.queryById(queoption.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.queoptionMapper.deleteById(id) > 0;
    }

    @Override
    public List<Queoption> queryAllByBean(Queoption statement) {
        return queoptionMapper.queryAllByBean(statement);
    }
}
