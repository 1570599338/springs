package com.lquan.service.impl;

import com.lquan.domain.ShiroUser;
import com.lquan.dao.ShiroUserMapper;
import com.lquan.service.ShiroUserService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (ShiroUser)表服务实现类
 *
 * @author lquan
 * @since 2022-03-08 17:28:59
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService {
    @Resource
    private ShiroUserMapper shiroUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShiroUser queryById(String id) {
        return this.shiroUserMapper.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser insert(ShiroUser shiroUser) {
        this.shiroUserMapper.insert(shiroUser);
        return shiroUser;
    }
    
    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser insertSelective(ShiroUser shiroUser) {
        this.shiroUserMapper.insertSelective(shiroUser);
        return shiroUser;
    }
    

    /**
     * 修改数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser update(ShiroUser shiroUser) {
        this.shiroUserMapper.update(shiroUser);
        return this.queryById(shiroUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.shiroUserMapper.deleteById(id) > 0;
    }
}
