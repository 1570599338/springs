package com.lquan.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: springs
 * @description: 断言测试
 * @author: lquan
 * @create: 2022-12-16 19:59
 **/

public class JUnitAssertionsTest {

    @Test
    @DisplayName("简单断言")
    public void simple() {
        assertEquals(3, 1 + 2, "simple math");
        assertNotEquals(3, 1 + 1);

        assertNotSame(new Object(), new Object());
        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());
    }


    /**
     * 通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
     */
    @Test
    @DisplayName("数组断言")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    /**
     * assertAll 方法接受多个 org.junit.jupiter.api.Executable 函数式接口的实例作为要验证的断言，可以通过 lambda 表达式很容易的提供这些断言
     */
    @Test
    @DisplayName("组合断言")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }


    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }


    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }


    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

}
