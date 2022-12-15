package com.lquan.boot.service;

import com.lquan.boot.bean.Account;
import com.lquan.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 16:15
 **/
@Service
public class AccountService {

    @Autowired(required = false)
    private AccountMapper accountMapper;

    /**
     * 获取account的信息
     * @param id
     * @return
     */
    public Account getAcc(Long id){
        id=id ==null?1:id;
        return accountMapper.getAcc(id);
    }
}
