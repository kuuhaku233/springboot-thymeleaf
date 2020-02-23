package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.SysUserMapper;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysUserService;
import com.example.springbootthymeleaf.util.GetIpcofig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sud;

    @Override
    public List<User> getSysUsers(String start, String length, String ordercolumn, String orderdir) {
        return sud.getSysUsers(start, length, ordercolumn, orderdir);
    }

    @Override
    public int updateUserMess(int uid, String username,
                              String password, String email, String phone, String signed) {
        return sud.updateUserMess(uid, username,
                password, email, phone, signed);
    }

    @Override
    //删除用户信息
    public int deleteUserMess(int uid) {
        return sud.deleteUserMess(uid);
    }

    @Override
    //新增用户信息
    public int addUserMess(User su) throws UnsupportedEncodingException {
        su.setRegister_time(new Timestamp(new Date().getTime()));
        su.setLogin_count("0");
        String ip=GetIpcofig.getlocalIp(); //内网ip地址
        System.out.println("ip"+ip);
        String netip=GetIpcofig.getnetIP();    //外网ip地址
        System.out.println("netip"+netip);
        GetIpcofig ipconf= new GetIpcofig();
        String ipaddress= ipconf.getAddresses("ip=" +netip,"UTF-8"); // 获取到完整的地址
        String currIpaddress=ipaddress.substring(4,14);  //包含 X国家 XX省 XX市
        su.setRegister_address(currIpaddress);
        System.out.println(currIpaddress);
        System.out.println("ipaddress"+ipaddress);
        try {
            return sud.addUserMess(su);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //验证手机号是否存在
    @Override
    public boolean getUserPhoneYanZheng(String phone) {
        return sud.getUserPhoneYanZheng(phone);
    }

    @Override
    public List<User> getUserInfo(String idList) {
        return sud.getUserInfo(idList);
    }


}
