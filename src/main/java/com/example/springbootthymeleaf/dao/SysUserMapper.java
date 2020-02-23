package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SysUserMapper {

    //获取所有用户信息
    public List<User> getSysUsers(String start, String length, String ordercolumn, String orderdir);

    //修改用户信息
    public int updateUserMess(@Param("uid") int uid, @Param("username") String username,
                              @Param("password") String password,
                              @Param("email") String email, @Param("phone") String phone,
                              @Param("signed") String signde);

    //删除用户信息
    public int deleteUserMess(int uid);

    //新增用户信息
    public int addUserMess(User su) throws UnsupportedEncodingException;

    //验证手机号是否存在
    public boolean getUserPhoneYanZheng(String phone);

    //导出excle表格
    List<User> getUserInfo(String idList);
}
