package com.lquan.service;

import com.lquan.domain.Menu;
import com.lquan.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Set;

/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 23:59:34
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu queryById(Long id);

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Menu> queryByPage(Menu menu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu insert(Menu menu);
    
        /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu insertSelective(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(Long userId);


    /**
     * 根据用户ID查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<Menu> selectMenusByUser(User user);

}
