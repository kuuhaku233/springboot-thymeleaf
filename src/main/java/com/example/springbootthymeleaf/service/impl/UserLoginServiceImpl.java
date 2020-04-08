package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.UserLoginMapper;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.UserLoginService;
import com.example.springbootthymeleaf.util.GetIpcofig;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginDao;

    @Override
    public User userLogin(User user) {
        return userLoginDao.userLogin(user);
    }

    @Override
    public User findByUsername(String username) {
        return userLoginDao.findByUsername(username);
    }

    @Override
    public Integer getRegister(User user) {
        //  进行随机盐值生成
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);
        String newPass =new Md5Hash(user.getPassword(),salt,1903).toString();
//        String newPass = new SimpleHash("md5", user.getPassword(), ByteSource.Util.bytes(salt)).toString();
        user.setPassword(newPass);
        user.setRegister_time(new Timestamp(new Date().getTime()));
        user.setLogin_count("0");
        /*String ip = GetIpcofig.getlocalIp(); //内网ip地址
        System.out.println("ip" + ip);
        String netip = GetIpcofig.getnetIP();    //外网ip地址
        System.out.println("netip" + netip);
        GetIpcofig ipconf = new GetIpcofig();*/
        String ipaddress = null; // 获取到完整的地址
        String currIpaddress =null;
      /*  try {
            ipaddress = ipconf.getAddresses("ip=" + netip, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        if(!StringUtils.isEmpty(ipaddress))
        {
            currIpaddress = ipaddress.substring(4, 14);  //包含 X国家 XX省 XX市
        }
        currIpaddress="河南省 洛阳市";
        user.setRegister_address(currIpaddress);
        System.out.println(currIpaddress);
        System.out.println("ipaddress" + ipaddress);
        return userLoginDao.getRegister(user);
    }

    @Override
    public Boolean verifyUserName(String username) {
        User user =userLoginDao.verifyUserName(username);
                if(user!=null)
                {
                    return false;
                }
                else {
                    return true;
                }
    }
}
