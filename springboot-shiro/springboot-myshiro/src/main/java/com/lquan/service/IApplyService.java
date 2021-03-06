package com.lquan.service;

import com.lquan.domain.Apply;

import java.util.List;

/**
 * 愿望申领单Service接口
 *
 * @author lquan
 * @date 2022-02-23
 */
public interface IApplyService {
    /**
     * 查询愿望申领单
     *
     * @param id 愿望申领单ID
     * @return 愿望申领单
     */
    public Apply selectApplyById(Integer id);

    /**
     * 查询愿望申领单列表
     *
     * @param apply 愿望申领单
     * @return 愿望申领单集合
     */
    public List<Apply> selectApplyList(Apply apply);

    /**
     * 新增愿望申领单
     *
     * @param apply 愿望申领单
     * @return 结果
     */
    public int insertApply(Apply apply);

    /**
     * 修改愿望申领单
     *
     * @param apply 愿望申领单
     * @return 结果
     */
    public int updateApply(Apply apply);

    /**
     * 批量删除愿望申领单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApplyByIds(String ids);

    /**
     * 删除愿望申领单信息
     *
     * @param id 愿望申领单ID
     * @return 结果
     */
    public int deleteApplyById(Integer id);
}
