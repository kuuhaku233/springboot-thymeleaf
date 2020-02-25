package com.example.springbootthymeleaf.realm;

import com.example.springbootthymeleaf.pojo.Resource;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysResourceService;
import com.example.springbootthymeleaf.service.UserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    SysResourceService sysResourceService;

    // 执行授权的逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Resource> listers = sysResourceService.getRoleLinkByRoleId(user.getRoleid());
        if (listers == null) {
            return null;
        }
        Set<String> resources = new HashSet<>();
        for (Resource resource : listers) {
            if (!StringUtils.isEmpty(resource.getRelink())) {
                resources.add(resource.getRelink());
            }
        }
//        System.out.println(resources);
        info.addStringPermissions(resources);

        return info;
    }

    // 执行认证的逻辑代码
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("认证逻辑");
        String salt="eed405499df6f53c8c27133dc34d97c1";
        //编写shiro的判断逻辑
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userLoginService.findByUsername(token.getUsername());
        if (user == null) {
            return null;
        }
        if(user.getSalt()==null)
        {
            return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(salt),getName());
        }
//        System.out.println("md5"+ByteSource.Util.bytes(salt));

        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }

}
