package com.lquan.layui.service.impl;

import com.lquan.layui.bean.resp.MenuTreeResult;
import com.lquan.layui.constant.Constant;
import com.lquan.layui.dao.TbMenuDao;
import com.lquan.layui.domain.TbMenu;
import com.lquan.layui.domain.TbRoleMenu;
import com.lquan.layui.service.TbMenuService;
import com.lquan.layui.service.TbRoleMenuService;
import com.lquan.layui.utills.CommonUtils;
import com.lquan.layui.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * (TbMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 14:58:20
 */
@Service("tbMenuService")
public class TbMenuServiceImpl implements TbMenuService {
    @Resource
    private TbMenuDao tbMenuDao;

    @Resource
    private TbRoleMenuService tbRoleMenuService;

    @Resource
    private CommonUtils commonUtils;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbMenu queryById(String id) {
        return this.tbMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbMenu> queryAllByLimit(int offset, int limit) {
        return this.tbMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbMenu insert(TbMenu tbMenu, HttpServletRequest request) {
        commonUtils.initTbData(tbMenu,true);
        this.tbMenuDao.insert(tbMenu);
        return tbMenu;
    }

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbMenu update(TbMenu tbMenu, HttpServletRequest request) {
        commonUtils.initTbData(tbMenu,false);
        this.tbMenuDao.update(tbMenu);
        return this.queryById(tbMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbMenuDao.deleteById(id) > 0;
    }

    @Override
    public List<TbMenu> getMenus() {
        return tbMenuDao.getMenus();
    }

    @Override
    public List<TbMenu> getMenusByUserId() {
        String userId = JwtTokenUtil.getUserId(Constant.base64Secret);
        return tbMenuDao.getMenusByUserId(userId);
    }

    @Override
    public List<TbMenu> getList() {
        return tbMenuDao.findAll();
    }

    @Override
    public List<TbMenu> getMenuByName(String name) {
        return tbMenuDao.getMenuByName("%"+name+"%");
    }

    @Override
    public List<MenuTreeResult> getMenusByRoleId(String roleId) {
        List<MenuTreeResult> roleMenuResults = new ArrayList<>();
        List<TbMenu> allList = tbMenuDao.findAll();
        List<TbMenu> list = allList.stream()
                .filter(menu->"0".equals(menu.getParentNumber())).collect(Collectors.toList());
        List<TbMenu> childrenMenuList = allList;
        childrenMenuList.remove(list);
        Map<String,List<TbMenu>> childrenMap = allList.stream().
                collect(Collectors.groupingBy(TbMenu::getParentNumber));

        List<TbRoleMenu> roleMenuList = tbRoleMenuService.findByMenuIdsAndRole(
                childrenMenuList.stream().map(e->e.getId()).collect(Collectors.toList()),roleId);

        Map<String, TbRoleMenu> checkedMap = roleMenuList.stream()
                .collect(Collectors.toMap(TbRoleMenu::getMenuId, Function.identity()));

        list.forEach(e->{
            List<MenuTreeResult> childrenList = new ArrayList<>();
            if(childrenMap.get(e.getNumber())!=null){
                childrenMap.get(e.getNumber()).forEach(c->{
                    MenuTreeResult result = new MenuTreeResult(c.getId(),c.getName()
                            ,checkedMap.get(c.getId())==null?false:true);
                    childrenList.add(result);
                });
            }
            MenuTreeResult result = new MenuTreeResult(e.getId(),e.getName(),childrenList);
            roleMenuResults.add(result);
        });
        return roleMenuResults;

    }

}