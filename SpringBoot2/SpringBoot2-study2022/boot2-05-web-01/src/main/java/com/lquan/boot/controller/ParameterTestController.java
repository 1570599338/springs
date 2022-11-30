package com.lquan.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lquan
 * @create 2022- 11-29 下午4:06
 * @description
 */


@RestController
public class ParameterTestController {

    /***
     *
     * @param id
     * @param name
     * @param
     * @return
     * 注解@PathVariable的使用
     *
     *  请求的url地址：127.0.0.1:8080/pv/1/owner/lquan
     */
    @GetMapping("/pv/{id}/owner/{username}")
    public Map<String,Object> getPV(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv){
        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        return map;
    }

    /**
     *
     * @param id
     * @param name
     * @param rh
     * @return
     * 注解@RequestHeader获取head参数信息和全部的头信息
     *
     */
    @GetMapping("/rh")
    public Map<String,Object> getRH(@RequestHeader("User-Agent") String userAgent,
                                    @RequestHeader Map<String,String> header){
        Map<String,Object> map = new HashMap<>();

        map.put("useragent",userAgent);
        map.put("header",header);

        return map;
    }


    /**
     * 注解：@RequestParam的使用
     * @param userAgent
     * @param header
     * @return
     */
    @GetMapping("/rp")
    public Map<String,Object> getRP( @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params){
        Map<String,Object> map = new HashMap<>();

        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);

        return map;
    }

    /**
     * 注解：@CookieValue的使用
     * @param _ga
     * @param abc
     * @param cookie
     * @param cookie2
     * @return
     */
    @GetMapping("/cv")
    public Map<String,Object> getCV(   @CookieValue("_ga") String _ga,
                                       @CookieValue("abc") String abc,
                                       @CookieValue("_ga") Cookie cookie,
                                       @CookieValue("abc") Cookie cookie2
                                       ){
        Map<String,Object> map = new HashMap<>();

        map.put("_ga",_ga);
        map.put("abc",abc);
        System.out.println("cookie: " + cookie.getName()+" = "+cookie.getValue());
        System.out.println("cookie2: " + cookie2.getName()+" = "+cookie2.getValue());

        return map;
    }

    //  car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga") String _ga,
                                     @CookieValue("_ga") Cookie cookie){


        Map<String,Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("_ga",_ga);
        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }

    /**
     * 注解：@RequestBody的使用
     * @param content
     * @return
     *
     *
     */
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("low",content);
        return map;
    }


    /**
     *
     * @param low
     * @param brand
     * @return
     *
     * 矩阵变量
     *      1、语法：/mv/v;low=34;brand=audi,bmw,byd
     */

    @GetMapping("/mv/{path}")
    public Map getMV(@MatrixVariable("low") Integer low,
                     @MatrixVariable("brand") List<String> brand,
                     @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }


    //1、语法： 请求路径：/boss/1;age=20/2;age=10
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;

    }

}