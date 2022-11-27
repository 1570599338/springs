package com.lquan.config;

import ch.qos.logback.core.db.DBHelper;
import com.lquan.bean.Bus;
import com.lquan.bean.Pet;
import com.lquan.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lquan
 * @create 2022- 11-26 下午5:23
 * @description 1、配置类里面使用的@Bean标注在方法上给容器注册组件，默认也是单例
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 * full(proxyBeanMethods = true) 【保证每个@Bean 方法被调用多少次返回的组件都是实例】
 * lite(proxyBeanMethods = false) 【每次@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式默认，其他默认是否Lite模式
 * <p>
 * 4、@Import({User.class,DBHelper.class})
 * 给容器中自动创建出两个类型的组件、默认组件的名字就是全类名
 */
@ImportResource("classpath:beans.xml")
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
@EnableConfigurationProperties(Bus.class)//1、开启了Bus配置绑定功能 2、把这个bus组件自动注册到容器中
public class Myconfig {

    @Bean //给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01() {

        return new User("Jim", 17);
    }

    @Bean("tomlquan") //可以自定义组件名称
    public Pet tomPet() {
        return new Pet("catTom");
    }

    @Bean
    public Pet tomPetx(Pet tomlquan) {//此处的tomlquan就是上面组件的pet

        System.out.println("****************************tomPetx:  " + tomlquan.toString());
        return new Pet("catTomxxx");
    }
}
