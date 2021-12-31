package com.lquan.layui.service.impl;

import com.lquan.layui.dao.TbCourseMapper;
import com.lquan.layui.domain.TbCourse;
import com.lquan.layui.service.TbCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TbCourse)表服务实现类
 *
 * @author makejava
 * @since 2021-12-29 16:34:39
 */
@Service
public class TbCourseServiceImpl implements TbCourseService {
    @Resource
    private TbCourseMapper tbCourseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbCourse queryById(Long id) {
        return this.tbCourseMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbCourse 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbCourse> queryByPage(TbCourse tbCourse, PageRequest pageRequest) {
        long total = this.tbCourseMapper.count(tbCourse);
        return new PageImpl<>(this.tbCourseMapper.queryAllByLimit(tbCourse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TbCourse insert(TbCourse tbCourse) {
        this.tbCourseMapper.insert(tbCourse);
        return tbCourse;
    }
    
    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TbCourse insertSelective(TbCourse tbCourse) {
        this.tbCourseMapper.insertSelective(tbCourse);
        return tbCourse;
    }
    

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TbCourse update(TbCourse tbCourse) {
        this.tbCourseMapper.update(tbCourse);
        return this.queryById(tbCourse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbCourseMapper.deleteById(id) > 0;
    }
}
