package com.lquan.service;

import com.lquan.domain.Account;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2023-01-17 02:52:42
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Account queryById(Long id);


    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);
    
        /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insertSelective(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
