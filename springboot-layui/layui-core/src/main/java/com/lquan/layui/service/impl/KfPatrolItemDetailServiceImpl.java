package com.lquan.layui.service.impl;

import com.lquan.layui.dao.KfPatrolItemDetailDao;
import com.lquan.layui.domain.KfPatrolItemDetail;
import com.lquan.layui.service.KfPatrolItemDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 检查点详情信息(KfPatrolItemDetail)表服务实现类
 *
 */
@Service("kfPatrolItemDetailService")
public class KfPatrolItemDetailServiceImpl implements KfPatrolItemDetailService {
    @Resource
    private KfPatrolItemDetailDao kfPatrolItemDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public KfPatrolItemDetail queryById(Integer id) {
        return this.kfPatrolItemDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<KfPatrolItemDetail> queryAllByLimit(int offset, int limit) {
        return this.kfPatrolItemDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param kfPatrolItemDetail 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemDetail insert(KfPatrolItemDetail kfPatrolItemDetail) {
        this.kfPatrolItemDetailDao.insert(kfPatrolItemDetail);
        return kfPatrolItemDetail;
    }

    /**
     * 修改数据
     *
     * @param kfPatrolItemDetail 实例对象
     * @return 实例对象
     */
    @Override
    public KfPatrolItemDetail update(KfPatrolItemDetail kfPatrolItemDetail) {
        this.kfPatrolItemDetailDao.update(kfPatrolItemDetail);
        return this.queryById(kfPatrolItemDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.kfPatrolItemDetailDao.deleteById(id) > 0;
    }
}
