package com.lquan.dao;


import com.lquan.domain.TbQuartzJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TbQuartzJob)表数据库访问层
 *
 * @author lquan
 * @since 2022-01-20 16:14:04
 */
@Mapper 
public interface TbQuartzJobMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbQuartzJob queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbQuartzJob 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbQuartzJob> queryAllByLimit(TbQuartzJob tbQuartzJob, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbQuartzJob 查询条件
     * @return 总行数
     */
    long count(TbQuartzJob tbQuartzJob);

    /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 影响行数
     */
    int insert(TbQuartzJob tbQuartzJob);
    
        /**
     * 新增数据
     *
     * @param tbQuartzJob 实例对象
     * @return 影响行数
     */
    int insertSelective(TbQuartzJob tbQuartzJob);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbQuartzJob> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbQuartzJob> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbQuartzJob> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbQuartzJob> entities);

    /**
     * 修改数据
     *
     * @param tbQuartzJob 实例对象
     * @return 影响行数
     */
    int update(TbQuartzJob tbQuartzJob);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 查询定时任务
     * @param tbQuartzJob
     * @return
     */
    List<TbQuartzJob> queryQuartzJobList(TbQuartzJob tbQuartzJob);

    /**
     * 根据bean查询定时任务详情
     *
     * @param tbQuartzJob
     * @return
     */
    TbQuartzJob selectByBean(TbQuartzJob tbQuartzJob);

}

