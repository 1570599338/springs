package com.lquan.mapper;


import com.lquan.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-17 02:52:40
 */
@Mapper 
public interface AccountMapper {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Account queryById(Long id);


    /**
     * 统计总行数
     *
     * @param account 查询条件
     * @return 总行数
     */
    long count(Account account);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insert(Account account);
    
        /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insertSelective(Account account);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Account> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Account> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Account> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Account> entities);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

