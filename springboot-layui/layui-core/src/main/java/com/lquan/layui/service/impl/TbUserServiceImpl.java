package com.lquan.layui.service.impl;


import com.lquan.layui.bean.resp.ForgetInfo;
import com.lquan.layui.constant.Constant;
import com.lquan.layui.dao.TbUserDao;
import com.lquan.layui.domain.TbUser;
import com.lquan.layui.domain.TbUserRole;
import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.enums.ResultEnum;
import com.lquan.layui.exception.SystemException;
import com.lquan.layui.service.RedisService;
import com.lquan.layui.service.TbUserRoleService;
import com.lquan.layui.service.TbUserService;
import com.lquan.layui.utills.CommonUtils;
import com.lquan.layui.utills.SmsUtils;
import com.lquan.layui.utils.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2020-02-14 12:54:29
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    @Resource
    private RedisService redisService;

    @Resource
    private CommonUtils commonUtils;

    @Resource
    private SmsUtils smsUtils;

    @Resource
    private TbUserService tbUserService;

    @Resource
    private TbUserRoleService tbUserRoleService;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(String id) {
        return this.tbUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbUser> queryAllByLimit(int offset, int limit) {
        return this.tbUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        checkUserName(tbUser.getUserName());
        commonUtils.setTbUserInsertDefault(tbUser);
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    public void checkUserName(String userName) {
        TbUser user = tbUserService.queryByUserName(userName);
        if (user != null) {
            throw new SystemException(ResultEnum.USERNAME_IS_USER);
        }
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbUser update(TbUser tbUser, HttpServletRequest request) {
        if ("10001".equals(tbUser.getId())) {
            throw new SystemException("不可修改管理员信息，以防止被随意更改密码。");
        }
        checkUserName(tbUser.getUserName());
        commonUtils.initTbData(tbUser, false);
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        //此处做不可删除管理员的限制
        if ("10001".equals(id)) {
            throw new SystemException("不可删除管理员");
        }
        return this.tbUserDao.deleteById(id) > 0;
    }


    @Override
    public List<TbUser> findAll() {
        return tbUserDao.findAll();
    }

    @Override
    public String login(HttpServletResponse response, TbUser tbUser) {


        //明文密码MD5加密
        tbUser.setUserPassword(StrToMd5.Md5(tbUser.getUserPassword()));
        TbUser user = tbUserDao.login(tbUser);

        if (user == null) {
            throw new SystemException(ResultEnum.LOGIN_ERROR);
        }
        // 创建token
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUserName(), "user_role");
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        redisService.set(token, user.getId());
        Integer count = Integer.parseInt(redisService.get("count") == null ? "0" : redisService.get("count"));
        redisService.set("count", count+1);
        return token;
    }

    @Override
    public void updatePasswordByPhone(String forgetPhone, String newPassword) {
        String password = StrToMd5.Md5(newPassword);
        tbUserDao.updatePasswordByPhone(forgetPhone, password);

    }

    @Override
    public TbUser findTbUserByPhone(String forgetPhone) {
        return tbUserDao.findTbUserByPhone(forgetPhone);
    }

    @Override
    public String getUserNameByToken(String token) {
        //此处也可用JwtTokenUtil获取更加方便，但是此处因为JWT是我后面加的，这里就没做修改
        String userId = redisService.get(token);
        TbUser tbUser = tbUserDao.queryById(userId);
        return tbUser != null ? tbUser.getUserName() : null;

    }

    @Override
    public List<TbUser> getUserByName(String name) {
        return tbUserDao.getUserByName("%" + name + "%");
    }

    @Override
    public ResultVO forgetPassword(ForgetInfo info) {
        if (smsUtils.verification(info.getForgetPhone(), info.getForgetVerificationCode())) {
            TbUser tbUser = tbUserDao.findTbUserByPhone(info.getForgetPhone());
            if (tbUser == null) {
                return ResultVOUtil.error(ResultEnum.PHONE_NOT_BIND_USER);
            }
            info.setNewPassword(StrToMd5.Md5(info.getNewPassword()));
            tbUserDao.updatePasswordByPhone(info.getForgetPhone(), info.getNewPassword());
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(ResultEnum.PHONE_CODE_ERROR);
        }
    }

    @Override
    public void register(TbUser user, String verificationCode) {
        TbUser tbUser = tbUserDao.findTbUserByPhone(user.getPhone());
        if (tbUser != null) {
            throw new SystemException(ResultEnum.PHONE_IS_USER);
        }
        if (smsUtils.verification(user.getPhone(), verificationCode)) {
            String password = user.getUserPassword();
            commonUtils.setTbUserInsertDefault(user);
            user.setUserPassword(StrToMd5.Md5(password));
            this.insert(user);
            TbUserRole tbUserRole = new TbUserRole();
            tbUserRole.setUserId(user.getId());
            tbUserRole.setRoleId("10001");//这里默认给的管理员角色
            tbUserRole.setId(commonUtils.getUUID32());
            tbUserRole.setCreateTime(DateUtil.get14Date());
            tbUserRole.setUpdateTime(DateUtil.get14Date());
            tbUserRole.setUpdateUser("admin");
            tbUserRoleService.insert(tbUserRole);
        } else {
            throw new SystemException(ResultEnum.PHONE_CODE_ERROR);
        }
    }

    @Override
    public TbUser getUserInfo(HttpServletRequest request) {
        return this.queryById(JwtTokenUtil.getUserId(Constant.base64Secret));
    }

    @Override
    public List<TbUser> getUserList() {
        return tbUserDao.findAll();
    }

    @Override
    public TbUser queryByUserName(String userName) {
        return tbUserDao.queryByUserName(userName);
    }

    @Override
    public void addUser(TbUser user) {
        TbUser tbUser = tbUserDao.findTbUserByPhone(user.getPhone());
        if (tbUser != null) {
            throw new SystemException(ResultEnum.PHONE_IS_USER);
        }
        this.insert(user);
        TbUserRole tbUserRole = new TbUserRole();
        tbUserRole.setUserId(user.getId());
        //这里默认给的普通角色
        tbUserRole.setRoleId("10002");
        tbUserRole.setId(commonUtils.getUUID32());
        tbUserRole.setCreateTime(DateUtil.get14Date());
        tbUserRole.setUpdateTime(DateUtil.get14Date());
        tbUserRole.setUpdateUser("admin");
        tbUserRoleService.insert(tbUserRole);
    }
}