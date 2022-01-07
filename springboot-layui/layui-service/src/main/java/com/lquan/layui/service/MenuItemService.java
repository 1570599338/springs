package com.lquan.layui.service;

import com.lquan.layui.domain.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MenuItem)表服务接口
 *
 * @author makejava
 * @since 2022-01-08 02:06:58
 */
public interface MenuItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MenuItem queryById(Long id);

    /**
     * 分页查询
     *
     * @param menuItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MenuItem> queryByPage(MenuItem menuItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    MenuItem insert(MenuItem menuItem);
    
        /**
     * 新增数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    MenuItem insertSelective(MenuItem menuItem);

    /**
     * 修改数据
     *
     * @param menuItem 实例对象
     * @return 实例对象
     */
    MenuItem update(MenuItem menuItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
