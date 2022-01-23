package com.lquan.service.impl;

import com.lquan.dao.TbQuartzJobMapper;
import com.lquan.domain.TbQuartzJob;
import com.lquan.service.TbQuartzJobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbQuartzJob)表服务实现类
 *
 * @author lquan
 * @since 2021-12-31 11:30:15
 */
@Service
public class TbQuartzJobServiceImpl implements TbQuartzJobService {
    @Resource
    private TbQuartzJobMapper tbQuartzJobMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbQuartzJob queryById(Integer id) {
        return this.tbQuartzJobMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbQuartzJob 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbQuartzJob> queryByPage(TbQuartzJob tbQuartzJob, PageRequest pageRequest) {
        long total = this.tbQuartzJobMapper.count(tbQuartzJob);
        return new PageImpl<>(this.tbQuartzJobMapper.queryAllByLimit(tbQuartzJob, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    @Override
    public TbQuartzJob insert(TbQuartzJob tbQuartzJob) {
        this.tbQuartzJobMapper.insert(tbQuartzJob);
        return tbQuartzJob;
    }
    
    /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    @Override
    public int insertSelective(TbQuartzJob tbQuartzJob) {

        return this.tbQuartzJobMapper.insertSelective(tbQuartzJob);
    }
    

    /**
     * 修改数据
     *
     * @param tbQuartzJob 实例对象
     * @return 实例对象
     */
    @Override
    public TbQuartzJob update(TbQuartzJob tbQuartzJob) {
        this.tbQuartzJobMapper.update(tbQuartzJob);
        return this.queryById(tbQuartzJob.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.tbQuartzJobMapper.deleteById(id);
    }


    /**
     * 查询定时任务
     * @param tbQuartzJob
     * @return
     */
    @Override
    public List<TbQuartzJob> queryQuartzJobList(TbQuartzJob tbQuartzJob) {
        return tbQuartzJobMapper.queryQuartzJobList(tbQuartzJob);
    }

    @Override
    public TbQuartzJob selectByBean(TbQuartzJob tbQuartzJob) {
        return tbQuartzJobMapper.selectByBean(tbQuartzJob);
    }
}
