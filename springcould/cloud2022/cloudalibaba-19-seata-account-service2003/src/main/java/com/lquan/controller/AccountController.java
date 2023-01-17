package com.lquan.controller;

import com.lquan.domain.Account;
import com.lquan.domain.CommonResult;
import com.lquan.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2023-01-17 02:52:43
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        String xid = RootContext.getXID();
        System.out.println("account-->xid"+xid);

        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Account> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.accountService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Account> add(Account account) {
        return ResponseEntity.ok(this.accountService.insert(account));
    }

    /**
     * 编辑数据
     *
     * @param account 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Account> edit(Account account) {
        return ResponseEntity.ok(this.accountService.update(account));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.accountService.deleteById(id));
    }

}

