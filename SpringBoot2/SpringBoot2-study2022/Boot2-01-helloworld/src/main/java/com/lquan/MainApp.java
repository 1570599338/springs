package com.lquan;

import ch.qos.logback.core.db.DBHelper;
import com.lquan.bean.Car;
import com.lquan.bean.Pet;
import com.lquan.bean.User;
import com.lquan.config.Myconfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author lquan
 * @create 2022- 11-26 下午2:23
 * @description
 */
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        //1、返回了IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApp.class);
        /**
         //2、查看容器里面的组件
         String[] beanDefinitionNames = run.getBeanDefinitionNames();// 获取所有容器中定义的名字
         for (String beanDefinitionName : beanDefinitionNames) {
         //   System.out.println("beanDefinitionName = " +beanDefinitionName);
         }
         System.out.println("************3******************");
         //3、从容器中获取组件
         Pet tomlquan = run.getBean("tomlquan", Pet.class);
         System.out.println("tomlquan:"+tomlquan.getName());

         System.out.println("************4******************");
         Myconfig bean = run.getBean(Myconfig.class);
         User user1 = bean.user01();
         User user2 = bean.user01();
         System.out.println("-->"+(user1==user2));

         // 5、import 获取组件
         System.out.println("===========================");
         String[] beanNamesForType = run.getBeanNamesForType(User.class);
         for (String s : beanNamesForType) {
         System.out.println("s: "+s);
         }

         DBHelper bean1 = run.getBean(DBHelper.class);
         System.out.println(bean1);

         //6、@ImportResource
         User haha = run.getBean("haha", User.class);
         Pet hehe = run.getBean("hehe", Pet.class);
         System.out.println(haha.getName()+"------"+hehe.getName());

         // 6、ConfigurationProperties
         System.out.println("===========================");
         Car bean2 = run.getBean(Car.class);
         System.out.println("bean2.toString() = " + bean2.toString());
         **/
    }
}
