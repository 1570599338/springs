package com.lquan.layui.service.impl;

import com.lquan.layui.domain.Question;
import com.lquan.layui.dao.QuestionMapper;
import com.lquan.layui.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2022-01-05 23:50:03
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Question queryById(Integer id) {
        return this.questionMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param question 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Question> queryByPage(Question question, PageRequest pageRequest) {
        long total = this.questionMapper.count(question);
        return new PageImpl<>(this.questionMapper.queryAllByLimit(question, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question insert(Question question) {
        this.questionMapper.insert(question);
        return question;
    }
    
    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question insertSelective(Question question) {
        this.questionMapper.insertSelective(question);
        return question;
    }
    

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question update(Question question) {
        this.questionMapper.update(question);
        return this.queryById(question.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.questionMapper.deleteById(id) > 0;
    }

    @Override
    public List<Question> queryAllByBean(Question statement) {
        return questionMapper.queryAllByBean(statement);
    }
}
