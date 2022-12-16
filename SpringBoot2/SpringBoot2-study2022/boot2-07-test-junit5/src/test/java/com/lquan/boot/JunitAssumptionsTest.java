package com.lquan.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.*;

/**
 * @program: springs
 * @description:  前置条件（assumptions）
 * @author: lquan
 * @create: 2022-12-16 20:34
 **/
@DisplayName("前置条件")
public class JunitAssumptionsTest {
    private final String environment = "DEV";

    @Test
    @DisplayName("simple")
    public void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DEV"));
        assumeFalse(() -> Objects.equals(this.environment, "PROD"));
    }

    @Test
    @DisplayName("assume then do")
    public void assumeThenDo() {
        assumingThat(
                Objects.equals(this.environment, "DEV"),
                () -> System.out.println("In DEV")
        );
    }
}
