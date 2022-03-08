package shiro;

import com.lquan.dao.ShiroUserMapper;
import com.lquan.domain.ShiroUser;
import com.lquan.domain.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-08 08:45
 **/
public class UserRealm  extends AuthorizingRealm {

    @Resource
    private ShiroUserMapper shiroUserMapper;

    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.printf("执行授权逻辑");
        // 给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 添加资源的授权字符串
        // info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        ShiroUser user = (ShiroUser) subject.getPrincipal();
        ShiroUser user11 = shiroUserMapper.queryById(user.getId());
        info.addStringPermission(user11.getAuthor());

        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.printf("执行认证逻辑");
        // 假设数据库的用户数据和密码
        //  String name ="lquan";
        // String password = "123456";

        // 编写shiro判断的逻辑，判断用户名和密码
        // 1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ShiroUser user = new ShiroUser();

        user.setUserName(token.getUsername());
        List<ShiroUser> list = shiroUserMapper.queryByname(user);

        if (list == null && list.size() <= 0) {
            return null;//shiro底层会抛出UnknowAccountException
        }

        //判断密码 第二位才是密码
        return new SimpleAuthenticationInfo(list.get(0), list.get(0).getUserPassword(), "");
    }
}
