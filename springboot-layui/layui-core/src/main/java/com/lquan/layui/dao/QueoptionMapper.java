package com.lquan.layui.dao;


import com.lquan.layui.domain.Queoption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Queoption)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-05 23:55:21
 */
@Mapper 
public interface QueoptionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Queoption queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param queoption 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Queoption> queryAllByLimit(Queoption queoption, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param queoption 查询条件
     * @return 总行数
     */
    long count(Queoption queoption);

    /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 影响行数
     */
    int insert(Queoption queoption);
    
        /**
     * 新增数据
     *
     * @param queoption 实例对象
     * @return 影响行数
     */
    int insertSelective(Queoption queoption);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Queoption> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Queoption> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Queoption> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Queoption> entities);

    /**
     * 修改数据
     *
     * @param queoption 实例对象
     * @return 影响行数
     */
    int update(Queoption queoption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<Queoption> queryAllByBean(Queoption queoption);



}

