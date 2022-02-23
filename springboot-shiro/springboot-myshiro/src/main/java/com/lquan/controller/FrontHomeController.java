package com.lquan.controller;

import com.lquan.common.shiro.ShiroUtils;
import com.lquan.common.utils.Constants;
import com.lquan.domain.About;
import com.lquan.domain.User;
import com.lquan.domain.Wish;
import com.lquan.service.IAboutService;
import com.lquan.service.IWishService;
import com.lquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: springs
 * @description: 前端页面
 * @author: lquan
 * @create: 2022-02-18 14:20
 **/
@Controller
@RequestMapping("/front")
public class FrontHomeController {

    private String prefix = "/front/pages/";
    @Autowired
    private IWishService wishService;

    @Autowired
    private UserService userService;

    // 系统首页
    @GetMapping("/index")
    public String indexFront(Model model) {
        model.addAttribute("index", Boolean.TRUE);
        return "front/index";
    }


    // 愿望清单
    @RequestMapping("/wishes")
    public String frontwishes( Model model) {


        Wish wish = new Wish();
        wish.setAuditStatus(Constants.audit_pass);
        List<Wish> list = wishService.selectWishList(wish);

        model.addAttribute("wisheList",  list);
        model.addAttribute("wishes",  Boolean.TRUE);
         return prefix + "wishes";
    }


    // 圆梦故事
    @RequestMapping("/realizations")
    public String frontRealizations( Model model) {
        model.addAttribute("realizations",  Boolean.TRUE);

        return prefix + "realizations";
    }


    // 圆梦故事
    @RequestMapping("/realizationInfo")
    public String frontRealizationInfo( Model model) {
        model.addAttribute("realizations",  Boolean.TRUE);

        return prefix + "realization-info";
    }

    @Autowired
    private IAboutService aboutService;
    // 联系我们
    @RequestMapping("/contact")
    public String frontContact( Model model) {
        model.addAttribute("contact",  Boolean.TRUE);

        List<About> list =aboutService.selectAboutList(new About());
        if(list!=null){
            model.addAttribute("about",  list.get(0));
        }else{
            model.addAttribute("about", "");
        }

        return prefix + "contact";
    }



    // 详细信息
    @RequestMapping("/wish")
    public String frontWisheHtml( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "wish";
    }

    // 详细信息
    @RequestMapping("/wish/{id}")
    public String frontWishe( Model model,@PathVariable("id") Integer id) {

       Wish wish = wishService.selectWishById(id);
        User user =userService.selectUserById(wish.getUserId().longValue());
        model.addAttribute("user",  user);
        model.addAttribute("wish",  wish);
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "wish";
    }


    // 详细信息
    @RequestMapping("/apply")
    public String frontApplyHtml( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "apply";
    }

    // 详细信息
    @RequestMapping("/apply/{id}")
    public String frontApply( Model model,@PathVariable("id") Integer id) {
        Wish wish = wishService.selectWishById(id);
        User user =userService.selectUserById(wish.getUserId().longValue());
        model.addAttribute("user",  user);
        model.addAttribute("wish",  wish);

        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "apply";
    }

    // 成功
    @RequestMapping("/apply_success")
    public String frontApplySuccess( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "apply_success";
    }
}
