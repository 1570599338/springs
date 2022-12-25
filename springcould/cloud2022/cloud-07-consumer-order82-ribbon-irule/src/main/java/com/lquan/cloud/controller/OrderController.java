package com.lquan.cloud.controller;

/**
 * @program: springcould
 * @description: 订单
 * @author: lquan
 * @create: 2022-12-23 12:59
 **/

import com.lquan.bean.CommonResult;
import com.lquan.bean.Payment;
import com.lquan.cloud.config.rule.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    //String urlStr="http://127.0.0.1:8001/";
    String urlStr="http://provider-payment07/";

    @GetMapping("/irule")
    public  String  getStrs(){

        String str = restTemplate.getForObject(urlStr+"payment/irule", String.class);
        log.info("返回值：{}",str);
        return  str;
    }
    
    @GetMapping("/")
    public  void  getStr(){

        String str = restTemplate.getForObject(urlStr+"payment/get/4", String.class);
        log.info("返回值：{}",str);
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        log.info("queryById->查询参数:{}",id);
        CommonResult<Payment> object = restTemplate.getForObject(urlStr + "payment/get/" + id, CommonResult.class);
        return object;
    }

    /**
     *
     * @param payment
     * @return
     */
    @RequestMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("create->参数:{}",payment);
        CommonResult<Payment> object = restTemplate.postForObject(urlStr + "payment/add",payment,CommonResult.class);
        return object;
    }


    @GetMapping("/getEntity/{id}")
    public CommonResult<Payment> queryByIdEntity(@PathVariable("id") Long id) {
        log.info("queryByIdEntity->查询参数:{}",id);
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(urlStr + "payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }
        return new CommonResult<>(444,"查询失败");
    }

    @RequestMapping("/createEntity")
    public CommonResult<Payment> createEntity(Payment payment) {
        log.info("create->参数:{}",payment);
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(urlStr + "payment/add", payment, CommonResult.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }
        return new CommonResult<>(444,"查询失败");
    }



    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/dis")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log . info ( "***** element:" + service );
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("provider-payment07");
        for (ServiceInstance instance : instances) {
            log.info("ServiceId:"+instance.getServiceId()+" |instanceId: "+instance.getInstanceId()+" |host: "+instance.getHost()+" |port: "+instance.getPort()+" |uri: "+instance.getUri()+" | ");
        }

        return discoveryClient;
    }

    @Autowired
    LoadBalancer loadBalancer;
    @GetMapping("/disBalancer")
    public String getDiscoveryBalancer() {


        List<ServiceInstance> instances = discoveryClient.getInstances("provider-payment07");
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);

        URI uri = serviceInstance.getUri();

        String str = restTemplate.getForObject(uri+"payment/irule", String.class);
        log.info("返回值：{}",str);

        return str;
    }

}
