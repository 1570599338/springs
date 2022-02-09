package com.lquan.service.impl;

import com.lquan.bean.Resp.Ztree;
import com.lquan.common.UserConstants;
import com.lquan.domain.Dept;
import com.lquan.mapper.DeptMapper;
import com.lquan.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
     * @param dept        筛选条件
     * @param pageRequest 分页对象
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


    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    @Override
    public List<Dept> selectDeptList(Dept dept) {
        return deptMapper.selectDeptList(dept);
    }


    /**
     * 查询部门管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    @Override
    public List<Ztree> selectDeptTree(Dept dept) {
        List<Dept> deptList = deptMapper.selectDeptList(dept);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }


    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList) {
        return initZtree(deptList, null);
    }

    /**
     * 对象转部门树
     *
     * @param deptList     部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList, List<String> roleDeptList) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
      //  boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (Dept dept : deptList) {
            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getId());
                ztree.setpId(dept.getParentId());
                ztree.setName(dept.getDeptName());
                ztree.setTitle(dept.getDeptName());
                if (roleDeptList != null) {
                    ztree.setChecked(roleDeptList.contains(dept.getId() + dept.getDeptName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

}
