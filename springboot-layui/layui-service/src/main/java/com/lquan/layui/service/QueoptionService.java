package com.lquan.layui.service;

import com.lquan.layui.domain.Queoption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Queoption)表服务接口
 *
 * @author makejava
 * @since 2022-01-05 23:55:32
 */
public interface QueoptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Queoption queryById(Integer id);

    /**
     * 分页查询
     *
     * @param queoption 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Queoption> queryByPage(Queoption queoption, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    Queoption insert(Queoption queoption);
    
        /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    Queoption insertSelective(Queoption queoption);

    /**
     * 修改数据
     *
     * @param queoption 实例对象
     * @return 实例对象
     */
    Queoption update(Queoption queoption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Queoption> queryAllByBean(Queoption statement);

}
