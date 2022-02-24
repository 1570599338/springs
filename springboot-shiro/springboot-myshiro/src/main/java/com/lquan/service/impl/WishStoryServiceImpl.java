package com.lquan.service.impl;

import java.util.List;

import com.lquan.common.shiro.ShiroUtils;
import com.lquan.common.text.Convert;
import com.lquan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lquan.mapper.WishStoryMapper;
import com.lquan.domain.WishStory;
import com.lquan.service.IWishStoryService;

import javax.annotation.Resource;

/**
 * 圆梦故事Service业务层处理
 *
 * @author lquan
 * @date 2022-02-24
 */
@Service
public class WishStoryServiceImpl implements IWishStoryService {
    @Resource
    private WishStoryMapper wishStoryMapper;

    /**
     * 查询圆梦故事
     *
     * @param id 圆梦故事ID
     * @return 圆梦故事
     */
    @Override
    public WishStory selectWishStoryById(Integer id) {
        return wishStoryMapper.selectWishStoryById(id);
    }

    /**
     * 查询圆梦故事列表
     *
     * @param wishStory 圆梦故事
     * @return 圆梦故事
     */
    @Override
    public List<WishStory> selectWishStoryList(WishStory wishStory) {
        return wishStoryMapper.selectWishStoryList(wishStory);
    }

    /**
     * 新增圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    @Override
    public int insertWishStory(WishStory wishStory) {
        wishStory.setCreateTime(DateUtils.getNowDate());
        return wishStoryMapper.insertWishStory(wishStory);
    }

    /**
     * 修改圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    @Override
    public int updateWishStory(WishStory wishStory) {
        wishStory.setUpdateTime(DateUtils.getNowDate());
        wishStory.setUpdateBy(ShiroUtils.getLoginName());
        return wishStoryMapper.updateWishStory(wishStory);
    }

    /**
     * 删除圆梦故事对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWishStoryByIds(String ids) {
        return wishStoryMapper.deleteWishStoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除圆梦故事信息
     *
     * @param id 圆梦故事ID
     * @return 结果
     */
    @Override
    public int deleteWishStoryById(Integer id) {
        return wishStoryMapper.deleteWishStoryById(id);
    }
}
