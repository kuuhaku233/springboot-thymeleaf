package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.User;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SysUserService {

    //获取所有用户信息
    public List<User> getSysUsers(String start, String length, String ordercolumn, String orderdir);

    //修改用户新息
    public int updateUserMess(int uid, String username,
                              String password, String email, String phone, String singed);

    //删除用户信息
    public int deleteUserMess(int uid);

    //新增用户信息
    public int addUserMess(User su) throws UnsupportedEncodingException;

    //验证手机号是否存在
    public boolean getUserPhoneYanZheng(String phone);

    //导出excle表格
    List<User> getUserInfo(String idList);
}
