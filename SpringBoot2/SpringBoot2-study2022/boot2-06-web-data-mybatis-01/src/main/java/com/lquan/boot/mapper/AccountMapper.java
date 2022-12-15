package com.lquan.boot.mapper;

import com.lquan.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 15:40
 **/
@Mapper
 public interface AccountMapper {

 /**
  * 获取账户信息
  * @param id
  * @return
  */
 public Account getAcc(Long id);

}
