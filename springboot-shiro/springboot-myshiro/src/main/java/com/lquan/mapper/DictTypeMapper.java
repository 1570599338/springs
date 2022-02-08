package com.lquan.mapper;


import com.lquan.domain.DictType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 字典类型表(DictType)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-08 23:58:49
 */
@Mapper 
public interface DictTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictType queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param dictType 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DictType> queryAllByLimit(DictType dictType, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dictType 查询条件
     * @return 总行数
     */
    long count(DictType dictType);

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 影响行数
     */
    int insert(DictType dictType);
    
        /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 影响行数
     */
    int insertSelective(DictType dictType);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DictType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictType> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DictType> entities);

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 影响行数
     */
    int update(DictType dictType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

