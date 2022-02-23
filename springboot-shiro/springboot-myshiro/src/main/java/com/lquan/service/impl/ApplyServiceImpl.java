package com.lquan.service.impl;

import java.util.List;

import com.lquan.common.text.Convert;
import com.lquan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lquan.mapper.ApplyMapper;
import com.lquan.domain.Apply;
import com.lquan.service.IApplyService;

import javax.annotation.Resource;

/**
 * 愿望申领单Service业务层处理
 *
 * @author lquan
 * @date 2022-02-23
 */
@Service
public class ApplyServiceImpl implements IApplyService {
    @Resource
    private ApplyMapper applyMapper;

    /**
     * 查询愿望申领单
     *
     * @param id 愿望申领单ID
     * @return 愿望申领单
     */
    @Override
    public Apply selectApplyById(Integer id) {
        return applyMapper.selectApplyById(id);
    }

    /**
     * 查询愿望申领单列表
     *
     * @param apply 愿望申领单
     * @return 愿望申领单
     */
    @Override
    public List<Apply> selectApplyList(Apply apply) {
        return applyMapper.selectApplyList(apply);
    }

    /**
     * 新增愿望申领单
     *
     * @param apply 愿望申领单
     * @return 结果
     */
    @Override
    public int insertApply(Apply apply) {
        apply.setCreateTime(DateUtils.getNowDate());
        return applyMapper.insertApply(apply);
    }

    /**
     * 修改愿望申领单
     *
     * @param apply 愿望申领单
     * @return 结果
     */
    @Override
    public int updateApply(Apply apply) {
        apply.setUpdateTime(DateUtils.getNowDate());
        return applyMapper.updateApply(apply);
    }

    /**
     * 删除愿望申领单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteApplyByIds(String ids) {
        return applyMapper.deleteApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除愿望申领单信息
     *
     * @param id 愿望申领单ID
     * @return 结果
     */
    @Override
    public int deleteApplyById(Integer id) {
        return applyMapper.deleteApplyById(id);
    }
}
