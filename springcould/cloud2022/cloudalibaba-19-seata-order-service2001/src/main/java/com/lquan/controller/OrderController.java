package com.lquan.controller;

import com.lquan.domain.CommonResult;
import com.lquan.domain.Order;
import com.lquan.service.AccountService;
import com.lquan.service.OrderService;
import com.lquan.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2023-01-17 02:29:32
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;



    @Resource
    private StorageService storageService;


    @GetMapping("/create")
    public CommonResult create(Order order){
        String xid = RootContext.getXID();
        System.out.println("account-->xid"+xid);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/account")
    public CommonResult testAccount(Order order){

        try {
            accountService.decrease(1l,new BigDecimal("10"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new CommonResult(200,"订单创建成功");
    }


    @GetMapping("/storage")
    public CommonResult testStorage(Order order){
        try {
            storageService.decrease(1l,1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new CommonResult(200,"订单创建成功");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.orderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param order 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Order> add(Order order) {
        return ResponseEntity.ok(this.orderService.insert(order));
    }

    /**
     * 编辑数据
     *
     * @param order 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Order> edit(Order order) {
        return ResponseEntity.ok(this.orderService.update(order));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.orderService.deleteById(id));
    }

}

