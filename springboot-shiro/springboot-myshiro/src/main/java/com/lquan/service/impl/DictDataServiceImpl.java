package com.lquan.service.impl;

import com.lquan.domain.DictData;
import com.lquan.mapper.DictDataMapper;
import com.lquan.service.DictDataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 字典数据表(DictData)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 23:58:30
 */
@Service
public class DictDataServiceImpl implements DictDataService {
    @Resource
    private DictDataMapper dictDataMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictData queryById(Long id) {
        return this.dictDataMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dictData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DictData> queryByPage(DictData dictData, PageRequest pageRequest) {
        long total = this.dictDataMapper.count(dictData);
        return new PageImpl<>(this.dictDataMapper.queryAllByLimit(dictData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData insert(DictData dictData) {
        this.dictDataMapper.insert(dictData);
        return dictData;
    }
    
    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData insertSelective(DictData dictData) {
        this.dictDataMapper.insertSelective(dictData);
        return dictData;
    }
    

    /**
     * 修改数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData update(DictData dictData) {
        this.dictDataMapper.update(dictData);
        return this.queryById(dictData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictDataMapper.deleteById(id) > 0;
    }
}
