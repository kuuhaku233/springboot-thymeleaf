package com.example.springbootthymeleaf.realm;
import com.example.springbootthymeleaf.pojo.Resource;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysResourceService;
import com.example.springbootthymeleaf.service.UserLoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    SysResourceService sysResourceService;

    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    //用于授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        User su= (User) principalCollection.getPrimaryPrincipal();
        //数据库查询权限信息
        List<Resource> listres=sysResourceService.getRoleLinkByRoleId(su.getRoleid());
        if(listres==null){
            return null;
        }else{
            //设置资源的集合
            Set<String> resource = new HashSet<>();
            for(Resource sr:listres){
                resource.add(sr.getRelink());
            }
            System.out.println(resource);

            //将权限信息保存到AuthorizationInfo中
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(resource);
            return simpleAuthorizationInfo;
        }

    }

    @Override
    //用于认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username=(String)token.getPrincipal();
        //获取密码
        String password =new String((char[])token.getCredentials());
        User su= new User();
        su.setUsername(username);
        su.setPassword(password);
        String salt="eed405499df6f53c8c27133dc34d97c1";

        //根据身份信息获取认证信息
        User user=userLoginService.userLogin(su);

        if(user==null){
            //返回空置表示验证不通过
            return null;
        }
        System.out.println(ByteSource.Util.bytes(salt));
        //返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user,user.getPassword(), ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
