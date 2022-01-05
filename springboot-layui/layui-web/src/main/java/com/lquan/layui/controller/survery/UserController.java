package com.lquan.layui.controller.survery;

import com.lquan.layui.bean.req.survery.Item;
import com.lquan.layui.bean.req.survery.Menu;
import com.lquan.layui.bean.req.survery.MenuItem;
import com.lquan.layui.bean.req.survery.UserPara;
import com.lquan.layui.dao.TbUserDao;
import com.lquan.layui.domain.TbUser;
import com.lquan.layui.dto.resp.ResultSurveryData;
import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.enums.ResultCodeEnum;
import com.lquan.layui.enums.ResultEnum;
import com.lquan.layui.service.TbUserService;
import com.lquan.layui.utils.ResultVOUtil;
import com.lquan.layui.utils.StrToMd5;
import com.lquan.layui.validator.JwtIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    @Resource
    private TbUserDao tbUserDao;



    @JwtIgnore
    @RequestMapping("/login")
    public ResultSurveryData loginx(HttpServletResponse response, UserPara para ) {
        TbUser tbUser = new TbUser();
        tbUser.setUserName(para.getUserID());
        tbUser.setUserPassword(para.getPassword());
        //明文密码MD5加密
       /* tbUser.setUserPassword(StrToMd5.Md5(tbUser.getUserPassword()));
        TbUser user = tbUserDao.login(tbUser);*/
        log.info("survery登录");
        String token = tbUserService.login(response, tbUser);
        if (token != null) {
            return ResultSurveryData.bulidSuccessPageResult(token);
        } else {
            return ResultSurveryData.bulidFailResult(ResultCodeEnum.SYS_ERROR);
        }
    }


    @JwtIgnore
    @RequestMapping("/modNav1jsp")
    public ResultSurveryData modNav1jsp(HttpServletResponse response, UserPara para ) {

        Item item = new Item();
        item.setUrl("project1");
       List listitem=  new ArrayList<Item>();
        listitem.add(item);

        Item item1 = new Item();
        item1.setUrl("project2");
        List listitem1=  new ArrayList<Item>();
        listitem1.add(item1);


        MenuItem menuItem0 = new MenuItem();
        menuItem0.setId(1);
        menuItem0.setText("问卷管理");
        menuItem0.setIcon("fa-stack-exchange");
        menuItem0.setUrl("project/sample.html");
        menuItem0.setTarget("workspace");
        menuItem0.setChildren(listitem);
        MenuItem menuItem = new MenuItem();
        menuItem.setId(1);
        menuItem.setText("问卷设计");
        menuItem.setIcon("fa-pencil-square-o");
        menuItem.setUrl("project/template.html");
        menuItem.setTarget("workspace");
        menuItem.setChildren(listitem1);


        List<MenuItem> itemslist = new ArrayList<>();
        itemslist.add(menuItem0);
        itemslist.add(menuItem);

        Menu menu = new Menu();
        menu.setId(1);
        menu.setText("业务管理");
        menu.setIcon("fa fa-cubes");
        menu.setChildren(itemslist);

        List<Menu> menulist = new ArrayList<>();
        menulist.add(menu);




        return ResultSurveryData.bulidSuccessPageResult(menulist);

    }


    @JwtIgnore
    @RequestMapping("/sysmngInitTemplate")
    public ResultSurveryData sysmngInitTemplate(HttpServletResponse response, @RequestParam(required = false,value = "userId") String userId,
                                                @RequestParam(required = false,value = "subSys") String subSys,
                                                @RequestParam(required = false,value = "tplID") String tplID,
                                                @RequestParam(required = false,value = "userID") String userID) {
        TbUser user =tbUserService.queryByUserName(userID);
        user.setImageUrl("/common/images/kaishun.jpg");

        List<TbUser> list = new ArrayList<>();
        list.add(user);

        return ResultSurveryData.bulidSuccessPageResult(list);

    }

}
