package com.lquan.service.impl;

import com.lquan.common.utils.TreeUtils;
import com.lquan.domain.Menu;
import com.lquan.domain.User;
import com.lquan.mapper.MenuMapper;
import com.lquan.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.*;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 23:59:34
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(Long id) {
        return this.menuMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Menu> queryByPage(Menu menu, PageRequest pageRequest) {
        long total = this.menuMapper.count(menu);
        return new PageImpl<>(this.menuMapper.queryAllByLimit(menu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insert(Menu menu) {
        this.menuMapper.insert(menu);
        return menu;
    }
    
    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insertSelective(Menu menu) {
        this.menuMapper.insertSelective(menu);
        return menu;
    }
    

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuMapper.update(menu);
        return this.queryById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.menuMapper.deleteById(id) > 0;
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectPermsByUserId(Long userId) {
        List<String> perms = menuMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (perm!=null)
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据用户ID查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    @Override
    public List<Menu> selectMenusByUser(User user) {
        List<Menu> menus = new LinkedList<Menu>();
        // 管理员显示所有菜单信息
      //  if ("admin".equalsIgnoreCase(user.getLoginName())){
        if (user.isAdmin()){
            menus = menuMapper.selectMenuNormalAll();
        }else {
            menus = menuMapper.selectMenusByUserId(user.getId());
        }
        return TreeUtils.getChildPerms(menus, 0);
    }
}
