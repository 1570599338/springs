package com.lquan.service;

import com.lquan.domain.ShiroUser;


/**
 * (ShiroUser)表服务接口
 *
 * @author lquan
 * @since 2022-03-08 17:28:59
 */
public interface ShiroUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiroUser queryById(String id);



    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser insert(ShiroUser shiroUser);
    
        /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser insertSelective(ShiroUser shiroUser);

    /**
     * 修改数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser update(ShiroUser shiroUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
