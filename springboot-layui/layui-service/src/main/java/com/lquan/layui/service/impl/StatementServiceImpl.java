package com.lquan.layui.service.impl;

import com.lquan.layui.domain.Statement;
import com.lquan.layui.dao.StatementMapper;
import com.lquan.layui.service.StatementService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Statement)表服务实现类
 *
 * @author makejava
 * @since 2022-01-05 23:56:41
 */
@Service
public class StatementServiceImpl implements StatementService {
    @Resource
    private StatementMapper statementMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Statement queryById(Integer id) {
        return this.statementMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param statement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Statement> queryByPage(Statement statement, PageRequest pageRequest) {
        long total = this.statementMapper.count(statement);
        return new PageImpl<>(this.statementMapper.queryAllByLimit(statement, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    @Override
    public Statement insert(Statement statement) {
        this.statementMapper.insert(statement);
        return statement;
    }
    
    /**
     * 新增数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    @Override
    public Statement insertSelective(Statement statement) {
        this.statementMapper.insertSelective(statement);
        return statement;
    }
    

    /**
     * 修改数据
     *
     * @param statement 实例对象
     * @return 实例对象
     */
    @Override
    public Statement update(Statement statement) {
        this.statementMapper.update(statement);
        return this.queryById(statement.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.statementMapper.deleteById(id) > 0;
    }

    @Override
    public List<Statement> queryAllByBean(Statement statement) {
        return statementMapper.queryAllByBean(statement);
    }
}
