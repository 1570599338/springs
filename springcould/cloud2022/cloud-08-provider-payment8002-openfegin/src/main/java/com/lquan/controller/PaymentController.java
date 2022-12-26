package com.lquan.controller;


import com.lquan.bean.CommonResult;
import com.lquan.bean.Payment;
import com.lquan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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

    @Value("${server.port}")
    private String port;


    @GetMapping(value = "/openfegin")
    public String paymentIRule(){
        return "springcloud with openfegin:"+port+"\t"+ UUID.randomUUID().toString();
    }


    @GetMapping(value = "/timeout")
    public String paymentTimeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        return "springcloud with timeout:"+port+"\t"+ UUID.randomUUID().toString();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        log.info("queryById->查询参数:{}",id);
        return new CommonResult<Payment>(200,"成功！"+port,this.paymentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param payment 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public CommonResult<Payment> add(@RequestBody Payment payment) {
        Payment insert = this.paymentService.insert(payment);
        return new CommonResult<Payment>(200,"成功！"+port,insert);
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
        return new CommonResult<Payment>(200,"修改成功！"+port);
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
        return new CommonResult<Payment>(200,"删除成功！"+port);
    }



   @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/dis")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log . info ( "***** element:" + service );
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("provider-payment04");
        for (ServiceInstance instance : instances) {
            log.info("ServiceId:"+instance.getServiceId()+" |instanceId: "+instance.getInstanceId()+" |host: "+instance.getHost()+" |port: "+instance.getPort()+" |uri: "+instance.getUri()+" | ");
        }

        return discoveryClient;
    }

}

