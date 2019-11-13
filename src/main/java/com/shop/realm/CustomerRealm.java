package com.shop.realm;

import com.shop.domain.User;
import com.shop.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=token.getPrincipal().toString();
        System.out.println("userName:"+userName);
        User user=null;
        try {
            user = userService.selectUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取数据异常!!!");
        }
        String password = user.getPassword();
        System.out.println("password:"+password);
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userName,password,"自定义realm");
        //根据身份信息从数据库里面查询
        return authenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
