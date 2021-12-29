package com.lquan.layui.dao;


import com.lquan.layui.domain.TbCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbCourse)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-29 16:29:42
 */
@Mapper 
public interface TbCourseMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCourse queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tbCourse 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbCourse> queryAllByLimit(TbCourse tbCourse, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbCourse 查询条件
     * @return 总行数
     */
    long count(TbCourse tbCourse);

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 影响行数
     */
    int insert(TbCourse tbCourse);
    
        /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 影响行数
     */
    int insertSelective(TbCourse tbCourse);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCourse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbCourse> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCourse> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbCourse> entities);

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 影响行数
     */
    int update(TbCourse tbCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

