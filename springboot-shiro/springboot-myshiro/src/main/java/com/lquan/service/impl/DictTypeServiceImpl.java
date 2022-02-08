package com.lquan.service.impl;

import com.lquan.domain.DictType;
import com.lquan.mapper.DictTypeMapper;
import com.lquan.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 字典类型表(DictType)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 23:58:49
 */
@Service
public class DictTypeServiceImpl implements DictTypeService {
    @Resource
    private DictTypeMapper dictTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictType queryById(Long id) {
        return this.dictTypeMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dictType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DictType> queryByPage(DictType dictType, PageRequest pageRequest) {
        long total = this.dictTypeMapper.count(dictType);
        return new PageImpl<>(this.dictTypeMapper.queryAllByLimit(dictType, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType insert(DictType dictType) {
        this.dictTypeMapper.insert(dictType);
        return dictType;
    }
    
    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType insertSelective(DictType dictType) {
        this.dictTypeMapper.insertSelective(dictType);
        return dictType;
    }
    

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType update(DictType dictType) {
        this.dictTypeMapper.update(dictType);
        return this.queryById(dictType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictTypeMapper.deleteById(id) > 0;
    }
}
