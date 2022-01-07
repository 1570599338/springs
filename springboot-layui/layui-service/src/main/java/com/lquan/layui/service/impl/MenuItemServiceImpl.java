package com.lquan.layui.service.impl;

import com.lquan.layui.domain.MenuItem;
import com.lquan.layui.dao.MenuItemMapper;
import com.lquan.layui.service.MenuItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (MenuItem)表服务实现类
 *
 * @author makejava
 * @since 2022-01-08 02:06:58
 */
@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Resource
    private MenuItemMapper menuItemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MenuItem queryById(Long id) {
        return this.menuItemMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param menuItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MenuItem> queryByPage(MenuItem menuItem, PageRequest pageRequest) {
        long total = this.menuItemMapper.count(menuItem);
        return new PageImpl<>(this.menuItemMapper.queryAllByLimit(menuItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    @Override
    public MenuItem insert(MenuItem menuItem) {
        this.menuItemMapper.insert(menuItem);
        return menuItem;
    }
    
    /**
     * 新增数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    @Override
    public MenuItem insertSelective(MenuItem menuItem) {
        this.menuItemMapper.insertSelective(menuItem);
        return menuItem;
    }
    

    /**
     * 修改数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    @Override
    public MenuItem update(MenuItem menuItem) {
        this.menuItemMapper.update(menuItem);
        return this.queryById(menuItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.menuItemMapper.deleteById(id) > 0;
    }
}
