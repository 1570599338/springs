package com.lquan.layui.service;

import com.lquan.layui.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Question)表服务接口
 *
 * @author makejava
 * @since 2022-01-05 23:50:03
 */
public interface QuestionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Question queryById(Integer id);

    /**
     * 分页查询
     *
     * @param question 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Question> queryByPage(Question question, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question insert(Question question);
    
        /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question insertSelective(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Question> queryAllByBean(Question statement);

}
