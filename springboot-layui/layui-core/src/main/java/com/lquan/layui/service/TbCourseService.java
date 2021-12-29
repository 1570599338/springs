package com.lquan.layui.service;

import com.lquan.layui.domain.TbCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbCourse)表服务接口
 *
 * @author makejava
 * @since 2021-12-29 16:29:43
 */
public interface TbCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCourse queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbCourse> queryByPage(TbCourse tbCourse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    TbCourse insert(TbCourse tbCourse);
    
        /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    TbCourse insertSelective(TbCourse tbCourse);

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    TbCourse update(TbCourse tbCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
