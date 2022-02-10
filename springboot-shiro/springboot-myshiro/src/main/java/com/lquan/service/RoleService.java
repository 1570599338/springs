package com.lquan.service;

import com.lquan.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Set;

/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2022-02-09 00:01:13
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Long id);

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Role> queryByPage(Role role, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);
    
        /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insertSelective(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(Long userId);



    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    public List<Role> selectRolesByUserId(Long userId);



    /**
     * 查询所有角色
     *
     * @return 角色列表
     */
    public List<Role> selectRoleAll();







}
