package com.lquan.layui.service.impl;

import com.lquan.layui.dao.KfPatrolItemPathDao;
import com.lquan.layui.domain.KfPatrolItemPath;
import com.lquan.layui.service.KfPatrolItemPathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 检查项父子深度表(KfPatrolItemPath)表服务实现类
 *
 * @author easycode
 * @since 2021-12-09 09:56:14
 */
@Service("kfPatrolItemPathService")
public class KfPatrolItemPathServiceImpl implements KfPatrolItemPathService {
    @Resource
    private KfPatrolItemPathDao kfPatrolItemPathDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ancestor 主键
     * @return 实例对象
     */
    @Override
    public KfPatrolItemPath queryById(Integer ancestor) {
        return this.kfPatrolItemPathDao.queryById(ancestor);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<KfPatrolItemPath> queryAllByLimit(int offset, int limit) {
        return this.kfPatrolItemPathDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemPath insert(KfPatrolItemPath kfPatrolItemPath) {
        this.kfPatrolItemPathDao.insert(kfPatrolItemPath);
        return kfPatrolItemPath;
    }

    /**
     * 修改数据
     *
     * @param kfPatrolItemPath 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemPath update(KfPatrolItemPath kfPatrolItemPath) {
        this.kfPatrolItemPathDao.update(kfPatrolItemPath);
        return this.queryById(kfPatrolItemPath.getAncestor());
    }

    /**
     * 通过主键删除数据
     *
     * @param ancestor 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ancestor) {
        return this.kfPatrolItemPathDao.deleteById(ancestor) > 0;
    }
}
