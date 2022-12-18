package com.lquan.boot.service;

import com.lquan.boot.bean.City;
import com.lquan.boot.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 18:13
 **/

@Slf4j
@Service
public class CityService {

    @Autowired(required = false)
    CityMapper cityMapper;


    @Transactional
    public City findById(long id){

        log.info("执行接口：findById");

        return cityMapper.findById(id);
    }


    public void insert(City city){
        log.info("执行接口：insert");
        cityMapper.insert(city);
    }


    /**
     * 利用xml形式的
     * @param id
     * @return
     */

    public City findByIdHx(long id){
        log.info("执行接口：findByIdHx");
        return cityMapper.findByIdHx(id);
    }


    /**
     * 利用xml形式的
     * @param city
     */
    public void insertHx(City city){
        log.info("执行接口：insertHx");
        cityMapper.insertHx(city);
    }





}
