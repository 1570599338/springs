package com.lquan.layui.service.impl;

import com.lquan.layui.dao.KfPatrolItemInfoDao;
import com.lquan.layui.domain.KfPatrolItemInfo;
import com.lquan.layui.service.KfPatrolItemInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 巡查检查项信息(KfPatrolItemInfo)表服务实现类
 *
 * @author easycode
 * @since 2021-12-08 18:06:57
 */
@Service("kfPatrolItemInfoService")
public class KfPatrolItemInfoServiceImpl implements KfPatrolItemInfoService {
    @Resource
    private KfPatrolItemInfoDao kfPatrolItemInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public KfPatrolItemInfo queryById(Integer id) {
        return this.kfPatrolItemInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<KfPatrolItemInfo> queryAllByLimit(int offset, int limit) {
        return this.kfPatrolItemInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemInfo insert(KfPatrolItemInfo kfPatrolItemInfo) {
        this.kfPatrolItemInfoDao.insert(kfPatrolItemInfo);
        return kfPatrolItemInfo;
    }

    /**
     * 修改数据
     *
     * @param kfPatrolItemInfo 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemInfo update(KfPatrolItemInfo kfPatrolItemInfo) {
        this.kfPatrolItemInfoDao.update(kfPatrolItemInfo);
        return this.queryById(kfPatrolItemInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.kfPatrolItemInfoDao.deleteById(id) > 0;
    }
}
