package com.lquan.layui.service;

import com.lquan.layui.bean.resp.ForgetInfo;
import com.lquan.layui.domain.TbUser;
import com.lquan.layui.dto.resp.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser, HttpServletRequest request);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * @description 获取所有用户
     * @author zhoukaishun
     * @date 2020/2/18 13:24
     */
    List<TbUser> findAll();

    String login(HttpServletResponse response, TbUser tbUser);

    /**
     * @description 根据手机号修改密码
     * @author zhoukaishun
     * @date 2020/3/15 10:29
     */
    void updatePasswordByPhone(String forgetPhone, String newPassword);

    TbUser findTbUserByPhone(String forgetPhone);

    String getUserNameByToken(String token);

    List<TbUser> getUserByName(String name);

    ResultVO forgetPassword(ForgetInfo info);

    void register(TbUser user, String verificationCode);

    TbUser getUserInfo(HttpServletRequest request);

    List<TbUser> getUserList();

    TbUser queryByUserName(String userName);

    void addUser(TbUser user);
}