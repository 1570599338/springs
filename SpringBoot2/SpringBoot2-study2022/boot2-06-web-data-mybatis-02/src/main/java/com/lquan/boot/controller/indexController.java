package com.lquan.boot.controller;

import com.lquan.boot.bean.City;
import com.lquan.boot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-14 19:25
 **/
@Slf4j
@Controller
public class indexController {


    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/cid")
    public City findByid(@RequestParam("id") Long id){

        return cityService.findById(id);
    }

    @ResponseBody
    @GetMapping("/ins")
    public String insert(){
        Random random = new Random();

        City city = new City();
        city.setName("name:"+random.nextInt());
        city.setCountry("country:"+random.nextInt());
        city.setState("1");

        cityService.insert(city);
 //       return cityService.findById(id);
        return city.toString();
    }




    @ResponseBody
    @GetMapping("/cidhx")
    public City findByidXml(@RequestParam("id") Long id){

        return cityService.findByIdHx(id);
    }

    @ResponseBody
    @GetMapping("/inshx")
    public String insertXml(){
        Random rm = new Random();

        City cityxml = new City();
        cityxml.setName("namehx:"+rm.nextInt());
        cityxml.setCountry("countryhx:"+rm.nextInt());
        cityxml.setState("1");

        cityService.insertHx(cityxml);
        //       return cityService.findById(id);
        return cityxml.toString();
    }

}
