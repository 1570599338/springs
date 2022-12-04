package com.lquan.boot.controller;

import com.lquan.boot.bean.Persion;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lquan
 * @create 2022- 12-03 下午7:03
 * @description
 *         数据响应与内容协商
 */

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/saveuser")
    public Persion postMethod(Persion persion){


        return persion;
    }


    @ResponseBody
    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public FileSystemResource getFiles(){

        String path="/Users/lquan/Desktop/20220324.txt";

        return new FileSystemResource(path);

    }


    /**
     * 1、浏览器请求直接返回xml 【application/xml]  jacksonXmlConverter
     * 2、如果是Ajax请求  返回json  【application/json]   jacksonJsonConverter
     * 3、如果其他appp发送请求，返回自定义协议数据  【application/x-lquan】  xxxConverter
     *              属性值1；属性值2；
     *
     * 步骤：
     *      1、添加自定义的MessageConverter进系统底层
     *      2、系统底层就会统计出所有MessageConverter能操作那些类型
     *      3、客户端内容协商[lquan -->lquan]
     * @return
     */
    @ResponseBody
    @PostMapping("/test/persion")
    public Persion getPersion(){
        Persion persion = new Persion();
        persion.setAge(18);
        persion.setBirth(new Date());
        persion.setUserName("lquan");
        return persion;
    }

}
