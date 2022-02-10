package com.lquan.service.impl;

import com.lquan.domain.Post;
import com.lquan.mapper.PostMapper;
import com.lquan.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位信息表(Post)表服务实现类
 *
 * @author makejava
 * @since 2022-02-09 00:00:53
 */
@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Post queryById(Long id) {
        return this.postMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param post        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Post> queryByPage(Post post, PageRequest pageRequest) {
        long total = this.postMapper.count(post);
        return new PageImpl<>(this.postMapper.queryAllByLimit(post, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post insert(Post post) {
        this.postMapper.insert(post);
        return post;
    }

    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post insertSelective(Post post) {
        this.postMapper.insertSelective(post);
        return post;
    }


    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post update(Post post) {
        this.postMapper.update(post);
        return this.queryById(post.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.postMapper.deleteById(id) > 0;
    }


    /**
     * 查询所有岗位
     *
     * @return 岗位列表
     */
    @Override
    public List<Post> selectPostAll() {
        return postMapper.selectPostAll();
    }
}
