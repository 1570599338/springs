package com.lquan.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lquan.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 21:38
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
