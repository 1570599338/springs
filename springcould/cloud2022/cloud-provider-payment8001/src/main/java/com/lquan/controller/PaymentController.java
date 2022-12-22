package com.lquan.controller;

import com.lquan.bean.resp.CommonResult;
import com.lquan.domain.Payment;
import com.lquan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author lquan
 * @since 2022-12-22 19:44:26
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        log.info("queryById->查询参数:{}",id);
        return new CommonResult<Payment>(200,"成功！",this.paymentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param payment 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public CommonResult<Payment> add(Payment payment) {
       this.paymentService.insert(payment);
        return new CommonResult<Payment>(200,"成功！");
    }

    /**
     * 编辑数据
     *
     * @param payment 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public CommonResult<Payment> edit(Payment payment) {
        this.paymentService.update(payment);
        return new CommonResult<Payment>(200,"修改成功！");
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/del/{id}")
    public CommonResult<Payment> deleteById(Long id) {
        this.paymentService.deleteById(id);
        return new CommonResult<Payment>(200,"删除成功！");
    }

}
