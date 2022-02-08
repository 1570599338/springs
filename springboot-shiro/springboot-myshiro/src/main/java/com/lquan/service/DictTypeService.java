package com.lquan.service;

import com.lquan.domain.DictType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 字典类型表(DictType)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 23:58:49
 */
public interface DictTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictType queryById(Long id);

    /**
     * 分页查询
     *
     * @param dictType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DictType> queryByPage(DictType dictType, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType insert(DictType dictType);
    
        /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType insertSelective(DictType dictType);

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType update(DictType dictType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
