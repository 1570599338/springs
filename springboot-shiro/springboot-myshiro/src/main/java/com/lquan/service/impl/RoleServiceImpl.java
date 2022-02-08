package com.lquan.service.impl;

import com.lquan.domain.Role;
import com.lquan.mapper.RoleMapper;
import com.lquan.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2022-02-09 00:01:13
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Long id) {
        return this.roleMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        long total = this.roleMapper.count(role);
        return new PageImpl<>(this.roleMapper.queryAllByLimit(role, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleMapper.insert(role);
        return role;
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insertSelective(Role role) {
        this.roleMapper.insertSelective(role);
        return role;
    }


    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleMapper.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleMapper.deleteById(id) > 0;
    }

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRoleKeys(Long userId) {
        List<Role> perms = roleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (Role perm : perms) {
            if (perm != null) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}
