package com.lquan.service.impl;

import com.lquan.domain.User;
import com.lquan.mapper.UserMapper;
import com.lquan.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-02-09 00:40:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userMapper.count(user);
        return new PageImpl<>(this.userMapper.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }
    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insertSelective(User user) {
        this.userMapper.insertSelective(user);
        return user;
    }
    

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userMapper.deleteById(id) > 0;
    }

    /**
     * 验证
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        // 查询用户信息
        User user = userMapper.selectUserByLoginName(username);

        return user;
    }
}
