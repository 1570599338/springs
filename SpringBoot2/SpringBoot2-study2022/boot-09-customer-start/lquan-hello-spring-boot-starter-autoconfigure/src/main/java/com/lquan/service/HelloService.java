package com.lquan.service;

import com.lquan.config.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author lquan
 * @create 2022- 12-21 下午9:48
 * @description
 *        默认不要放在容器中
 */

public class HelloService {

    @Autowired
    private HelloProperties helloProperties;

   public String sayHello(String userName){

       return helloProperties.getPrefix() +": "+userName+"->"+helloProperties.getSuffix();
   }
}
