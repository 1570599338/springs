package com.lquan.dao;

import com.lquan.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 18:47
 **/
public interface UserRep extends JpaRepository<User,Integer> {
}
