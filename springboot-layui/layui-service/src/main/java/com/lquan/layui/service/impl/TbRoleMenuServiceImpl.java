package com.lquan.layui.service.impl;

import com.lquan.layui.bean.req.RoleMenuInfo;
import com.lquan.layui.dao.TbRoleMenuDao;
import com.lquan.layui.domain.TbRoleMenu;
import com.lquan.layui.service.TbRoleMenuService;
import com.lquan.layui.utills.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 12:47:43
 */
@Service("tbRoleMenuService")
public class TbRoleMenuServiceImpl implements TbRoleMenuService {
    @Resource
    private TbRoleMenuDao tbRoleMenuDao;

    @Resource
    private CommonUtils commonUtils;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRoleMenu queryById(String id) {
        return this.tbRoleMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.tbRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbRoleMenu insert(TbRoleMenu tbRoleMenu) {
        this.tbRoleMenuDao.insert(tbRoleMenu);
        return tbRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbRoleMenu update(TbRoleMenu tbRoleMenu) {
        this.tbRoleMenuDao.update(tbRoleMenu);
        return this.queryById(tbRoleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbRoleMenuDao.deleteById(id) > 0;
    }

    @Override
    public List<TbRoleMenu> findMenuIdByRoleIds(List<String> roleIds) {
        return this.tbRoleMenuDao.findMenuIdByRoleIds(roleIds);
    }

    @Override
    public TbRoleMenu findByMenuIdAndRoleId(String menuId, String roleId) {
        return this.tbRoleMenuDao.findByMenuIdAndRoleId(menuId, roleId);
    }

    @Transactional
    @Override
    public void deleteAndInsertByRoleId(RoleMenuInfo info, HttpServletRequest request) {
        tbRoleMenuDao.deleteByRoleId(info.getRoleId());
        if (info.getMenuIds() != null) {
            List<String> menuIds = info.getMenuIds();
            menuIds.forEach(e -> {
                TbRoleMenu tbRoleMenu = new TbRoleMenu();
                commonUtils.initTbData(tbRoleMenu, true);
                tbRoleMenu.setMenuId(e);
                tbRoleMenu.setRoleId(info.getRoleId());
                tbRoleMenuDao.insert(tbRoleMenu);
            });
        }


    }

    @Override
    public List<TbRoleMenu> findByMenuIdsAndRole(List<String> menuIds, String roleId) {
        return tbRoleMenuDao.findByMenuIdsAndRole(menuIds, roleId);
    }
}