package com.lquan.service.impl;

import com.lquan.domain.Dept;
import com.lquan.mapper.DeptMapper;
import com.lquan.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 部门表(Dept)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 23:58:06
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Long id) {
        return this.deptMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Dept> queryByPage(Dept dept, PageRequest pageRequest) {
        long total = this.deptMapper.count(dept);
        return new PageImpl<>(this.deptMapper.queryAllByLimit(dept, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept insert(Dept dept) {
        this.deptMapper.insert(dept);
        return dept;
    }
    
    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept insertSelective(Dept dept) {
        this.deptMapper.insertSelective(dept);
        return dept;
    }
    

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept update(Dept dept) {
        this.deptMapper.update(dept);
        return this.queryById(dept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.deptMapper.deleteById(id) > 0;
    }
}
