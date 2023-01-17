package com.lquan.service;

import com.lquan.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 *
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping("/account/decrease")
     CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
