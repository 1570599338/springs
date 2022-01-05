package com.lquan.layui.service;

import com.lquan.layui.domain.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Template)表服务接口
 *
 * @author lquan
 * @since 2022-01-05 16:48:21
 */
public interface TemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Template queryById(Integer id);

    /**
     * 分页查询
     *
     * @param template 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Template> queryByPage(Template template, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    Template insert(Template template);
    
        /**
     * 新增数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    Template insertSelective(Template template);

    /**
     * 修改数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    Template update(Template template);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 通过条件查询
     * @param template
     * @return
     */
    List<Template> queryAllByBean(Template template);

}
