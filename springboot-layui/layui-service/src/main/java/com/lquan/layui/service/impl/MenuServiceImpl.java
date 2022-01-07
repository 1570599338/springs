package com.lquan.layui.service.impl;

import com.lquan.layui.bean.resp.survery.MenuResult;
import com.lquan.layui.domain.Menu;
import com.lquan.layui.dao.MenuMapper;
import com.lquan.layui.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2022-01-08 02:05:56
 */
@Service
public class MenuServiceImpl implements MenuService {


    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuResult> queryAllmenu(Integer id) {
        List<MenuResult> listTop =menuMapper.queryAllmenu(id);
        for (MenuResult bean :listTop){
            List<MenuResult> listmid =menuMapper.queryAllmenu(bean.getId());
            for (MenuResult item :listmid){
                List<MenuResult> listitem =menuMapper.queryAllmenuItem(item.getId());
                item.setChildren(listitem);
            }
            bean.setChildren(listmid);
        }
        return listTop;
    }

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
}
