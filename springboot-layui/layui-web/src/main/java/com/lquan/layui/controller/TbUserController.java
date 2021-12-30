package com.lquan.layui.controller;

import com.lquan.layui.bean.resp.ForgetInfo;
import com.lquan.layui.dao.TbUserDao;
import com.lquan.layui.domain.TbUser;
import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.enums.ResultEnum;
import com.lquan.layui.service.TbUserService;
import com.lquan.layui.utills.SmsUtils;
import com.lquan.layui.utils.Base64Util;
import com.lquan.layui.utils.MobileUtils;
import com.lquan.layui.utils.ResultVOUtil;
import com.lquan.layui.validator.JwtIgnore;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2020-02-14 12:54:29
 */
@RestController
@RequestMapping("tbUser")
@Slf4j
public class TbUserController {

    @Autowired
    private SmsUtils smsUtils;


    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation("根据id查询单个用户")
    public TbUser selectOne(String id) {
        return this.tbUserService.queryById(id);
    }


    /**************************begin**************************/
    /**
     * @description 获取用户信息
     * @author zhoukaishun
     * @date 2020/2/14 13:04
     */
    @PostMapping("/getList")
    public ResultVO getUserList() {
        log.info("获取所有用户信息");
        List<TbUser> list = tbUserService.getUserList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getUserByName")
    @ApiOperation(value = "根据用户名称查询用户集合")
    public ResultVO<List<TbUser>> getUserByName(String name) {
        List<TbUser> list = tbUserService.getUserByName(name);
        return ResultVOUtil.success(list);
    }


    @DeleteMapping("/delete")
    public ResultVO deleteUserById(String id) {
        log.info("删除用户，id={}", id);
        tbUserService.deleteById(id);
        return ResultVOUtil.success();
    }


    @JwtIgnore
    @PostMapping("/registerUser")
    @ApiOperation("用户注册")
    public ResultVO register(@Valid TbUser user, String verificationCode) {
        tbUserService.register(user, verificationCode);
        return ResultVOUtil.success();
    }

    @JwtIgnore
    @PostMapping("/forgetPassword")
    public ResultVO forgetPassword(@Valid ForgetInfo info) {
        log.info("忘记密码");
        return tbUserService.forgetPassword(info);
    }

    @PostMapping("/setUser")
    public ResultVO addUser(@Valid TbUser user) {
        log.info("注册用户");
        tbUserService.addUser(user);
        return ResultVOUtil.success();
    }

    @PutMapping("/setUser")
    public ResultVO updateUser(HttpServletRequest request, @Valid TbUser user) {
        log.info("更新用户");
        tbUserService.update(user, request);
        return ResultVOUtil.success();
    }

    @JwtIgnore
    @PostMapping("/login")
    public ResultVO login(HttpServletResponse response, TbUser tbUser) {
        log.info("登录");
        String token = tbUserService.login(response, tbUser);
        if (token != null) {
            return ResultVOUtil.loginSuccess(token);
        } else {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
    }

    @PostMapping("/logout")
    public ResultVO postLogout() {
        return ResultVOUtil.success();
    }

    @PostMapping("/info")
    public ResultVO getUserInfo(HttpServletRequest request) {
        log.info("通过token获取用户基本信息");
        TbUser tbUser = tbUserService.getUserInfo(request);
        return ResultVOUtil.success(tbUser);
    }

    @JwtIgnore
    @PostMapping("/sendCode")
    public ResultVO sendSms(String phone) {
        log.info("获取验证码");
        if (!MobileUtils.isMobile(phone)) {
            log.info("请输入正确的手机号");
            return ResultVOUtil.error(ResultEnum.PHONE_ERROR);
        }
        String responseData = smsUtils.sendMsg(phone, smsUtils.randomNumeric(6));
        return MobileUtils.sendResult(responseData);
    }

    @JwtIgnore
    @PostMapping("/testCode")
    public ResultVO test(String phone, String code) {
        log.info("短信验证码发送");
        if (!MobileUtils.isMobile(phone)) {
            log.info("请输入正确的手机号");
            return ResultVOUtil.error(ResultEnum.PHONE_ERROR);
        }
        String responseData = smsUtils.sendMsg(phone, code);
        return MobileUtils.sendResult(responseData);

    }

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @JwtIgnore
    @GetMapping("/mybatisCache")
    public void mybatisCache() {
        log.info("会话一查询");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbUserDao tbUserDao = sqlSession.getMapper(TbUserDao.class);
        TbUser tbUser = tbUserDao.queryById("10001");
        System.out.println(tbUser.toString());

        log.info("创建会话二，会话二修改数据，此时会清除二级缓存");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TbUserDao tbUserDao2 = sqlSession2.getMapper(TbUserDao.class);
        TbUser tbUser1 = new TbUser();
        tbUser1.setId("10001");
        tbUser1.setUserName("mybatis二级缓存");
        tbUserDao2.update(tbUser1);

        log.info("会话二中查询结果，查数据库，放入二级缓存");
        TbUser tbUser2 = tbUserDao2.queryById("10001");
        System.out.println(tbUser2.toString());
        log.info("此处必须commit");
        sqlSession2.commit();
        log.info("会话一此时再查询，会从二级缓存中查询，不会走库");
        TbUser user = tbUserDao.queryById("10001");
        System.out.println(user.toString());

    }

    @JwtIgnore
    @GetMapping("/testCount")
    public List<Integer> testCount() {
        List<Integer> count = tbUserDao.getCount();
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,2,4,6,6);
        System.out.println(list.stream().distinct().reduce(Integer::max).get());
        List<String> mobile = new ArrayList<>();
        mobile.add("18856034826");
        mobile.add("18856031111");
        List<String> newMoblies = new ArrayList<>();
        newMoblies.add("18856032222");
        newMoblies.add("18856034826");
        newMoblies.add("188560311112");

        newMoblies.forEach(e->{
            if(mobile.contains(e)){
                mobile.remove(e);
            }
        });
        //System.out.println("mobile.size="+mobile.size());
        setMobile();
        String MAC_NAME = "HmacSHA1";
        String ENCODING = "UTF-8";

        try {
            String s = HmacSHA1Encrypt("D9t4OgCT0n9K21Tr1UCd,GETapi-bj.clink.cn/list_cdr_ibs?AccessKeyId=26bb43f7c9d14da0c6e0e927f0a60475&Expires=3600&Timestamp=2021-11-16T15%3A55%3A30Z","D9t4OgCT0n9K21Tr1UCd");
            System.out.println(s);
            System.out.println(URLEncoder.encode(Base64Util.encode(s)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String HmacSHA1Encrypt(String encryptText,String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes("UTF-8");
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance("HmacSHA1");
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes("UTF-8");
        // 完成 Mac 操作
        return byte2hex(mac.doFinal(text));
    }

    //二行制转字符串
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    public  static void setMobile(){
        String mobile = "18856034826";
        System.out.println(mobile.substring(0,3));
        System.out.println(mobile.substring(7));
    }


}