package com.lquan.controller;

import com.lquan.bean.School;
import com.lquan.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @program: springs
 * @description: hello测试
 * @author: lquan
 * @create: 2022-02-16 16:24
 **/

@Controller
public class LinkController {






    @RequestMapping("link")
    public String express_link( Model model) {

        model.addAttribute("linkUrl","linkUrlxxxx!");
        return "link";
    }


    @RequestMapping("num")
    public String express_num( Model model) {

        model.addAttribute("n1",9);
        model.addAttribute("n2",5);
        return "num";
    }

    @RequestMapping("bool")
    public String express_bool( Model model) {

        model.addAttribute("married",Boolean.TRUE);
       // model.addAttribute("age",19);
        model.addAttribute("age",16);



        model.addAttribute("name",null);
        model.addAttribute("myname","");
        return "bool";
    }


    @RequestMapping("attr")
    public String express_attr( Model model) {

        model.addAttribute("myaction","/user/login");
        model.addAttribute("mytext","请登录");
        return "attr";
    }

    @RequestMapping("text")
    public String express_text( Model model) {

        model.addAttribute("aa","text学习雷锋<br>123,<p>222</p>");
        model.addAttribute("bb","utext学习雷锋<br>123,<p>222</p>");

        return "text";
    }

    @RequestMapping("foreach")
    public String express_foreach( Model model) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add( new Student(i+1,"name_"+i,i+1,"110@qq.com"+i));
        }
        model.addAttribute("students",list);


        List< Map<String,String>> listMap = new ArrayList<>();
        model.addAttribute("students",list);
        for (int i = 0; i < 10; i++) {
            Map<String,String> map = new HashMap<>();
            map.put("id",(i+1)+"");
            map.put("name","name_"+i);
            map.put("age",(i+1)+"");
            map.put("email","110@qq.com_"+i);
            listMap.add(map);
        }
        model.addAttribute("listMap",listMap);

        Map<String,String> map = new HashMap<>();
        map.put("id","18");
        map.put("name","name_18");
        map.put("age","18");
        map.put("email","18110@qq.com");
        model.addAttribute("map",map);

        String[] names={"刘波","网吧","是房东","请问","阿萨","爱仕达多","爱仕达多多"};
        model.addAttribute("names",names);


        Map<String,String> mapselect = new HashMap<>();
        mapselect.put("001","name_001");
        mapselect.put("002","name_002");
        mapselect.put("003","name_003");
        mapselect.put("004","name_004");
        mapselect.put("0052","name_052");
        model.addAttribute("mapselect",mapselect);
        model.addAttribute("chose","name_003");



        return "foreach";
    }


    @RequestMapping("if")
    public String express_if( Model model) {

        model.addAttribute("flageFalse",Boolean.FALSE);
        model.addAttribute("flageTrue",Boolean.TRUE);

        model.addAttribute("flage0",0);
        model.addAttribute("flage1",1);


        return "if";
    }

    @RequestMapping("fragment")
    public String express_fragment( Model model) {


        return "frag/main";
    }

    @RequestMapping("remove")
    public String remove( Model model) {


        return "frag/remove";
    }


    @RequestMapping("dynamic")
    public String dynamic( Model model) {
        model.addAttribute("tplname","menu");

        return "frag/dynamic";
    }

    @RequestMapping("inline")
    public String inline( Model model) {
        model.addAttribute("inlineJs","内联js的哈哈哈");

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add( new Student(i+1,"name_"+i,i+1,"110@qq.com"+i));
        }
        model.addAttribute("students",list);


        model.addAttribute("name","我爱你<b>中国</b>");
        return "inline";
    }


    @RequestMapping("with")
    public String with( Model model) {
        model.addAttribute("age",19);

        return "with";
    }


    @RequestMapping("toolObject")
    public String toolObject( Model model) {
        model.addAttribute("mydata",new Date());
        model.addAttribute("price",89.35);
        model.addAttribute("myname","zhangsan");

        return "toolObject";
    }
}
