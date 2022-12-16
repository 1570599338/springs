package com.lquan.boot;

import org.junit.jupiter.api.*;

/**
 * @program: springs
 * @description: Junit5的常用注解测试
 * @author: lquan
 * @create: 2022-12-16 18:16
 **/

@DisplayName("JUnit5常用注解测试") // 为测试类或者测试方法设置展示名称
public class JUnitBaseTest {

   @Test
   void  test(){
        System.out.println("@Test");
    }

    /**
     * @RepeatedTest :表示方法可重复执行，
     */
    @RepeatedTest(5) //表示方法可重复执行
     void  repeatedTest(){
        System.out.println("@RepeatedTest :表示方法可重复执行,参数代表可执行的次数");
    }

    @BeforeEach
    void  beforeEach(){
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void  afterEach(){
        System.out.println("@AfterEach");
    }


    @BeforeAll
    static void  beforeAll(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void  AfterAll(){
        System.out.println("@AfterAll");
    }

    @Disabled
    @Test
    void  disabledxx(){
        System.out.println("@Disabled");
    }

    @Test
    @Timeout(value = 1)
    void  Timeout() throws  Exception{
       Thread.sleep(100);
    }
}
