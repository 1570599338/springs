package com.lquan.layui.service.impl;

import com.lquan.layui.domain.Template;
import com.lquan.layui.dao.TemplateMapper;
import com.lquan.layui.service.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Template)表服务实现类
 *
 * @author lquan
 * @since 2022-01-05 16:48:21
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Resource
    private TemplateMapper templateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Template queryById(Integer id) {
        return this.templateMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param template 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Template> queryByPage(Template template, PageRequest pageRequest) {
        long total = this.templateMapper.count(template);
        return new PageImpl<>(this.templateMapper.queryAllByLimit(template, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    @Override
    public Template insert(Template template) {
        this.templateMapper.insert(template);
        return template;
    }
    
    /**
     * 新增数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    @Override
    public Template insertSelective(Template template) {
        this.templateMapper.insertSelective(template);
        return template;
    }
    

    /**
     * 修改数据
     *
     * @param template 实例对象
     * @return 实例对象
     */
    @Override
    public Template update(Template template) {
        this.templateMapper.update(template);
        return this.queryById(template.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.templateMapper.deleteById(id) > 0;
    }


    /**
     * 通过条件查询
     * @param template
     * @return
     */
    @Override
    public List<Template> queryAllByBean(Template template) {
        return templateMapper.queryAllByBean(template);
    }
}
