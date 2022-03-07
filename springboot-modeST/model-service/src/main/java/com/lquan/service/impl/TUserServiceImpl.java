package com.lquan.service.impl;

import com.lquan.domain.TUser;
import com.lquan.dao.TUserMapper;
import com.lquan.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表(TUser)表服务实现类
 *
 * @author lquan
 * @since 2022-03-07 21:37:50
 */
@Service
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserMapper tUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Long id) {
        return this.tUserMapper.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        this.tUserMapper.insert(tUser);
        return tUser;
    }
    
    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insertSelective(TUser tUser) {
        this.tUserMapper.insertSelective(tUser);
        return tUser;
    }
    

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserMapper.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tUserMapper.deleteById(id) > 0;
    }
}
