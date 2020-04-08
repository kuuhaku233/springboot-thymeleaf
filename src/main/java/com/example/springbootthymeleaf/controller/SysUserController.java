package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysUserService;
import com.example.springbootthymeleaf.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/")
public class SysUserController {
    @Autowired
    private SysUserService sus;
    @Autowired
    UserLoginService userLoginService;

    //获取用户信息
    @RequestMapping("getsysusers")
    @ResponseBody
    @ALog(desc="查看用户")
    public List<User> getSysUsers(String start, String length,
                                            HttpServletRequest reqeust) {
        //获取datatable的排序参数
        String order=reqeust.getParameter("order[0][column]");
        String orderdir=reqeust.getParameter("order[0][dir]");
        String ordercolumn = reqeust.getParameter("columns["+order+"][data]");

        List<User> listsus=sus.getSysUsers(start,length,ordercolumn,orderdir);
        reqeust.setAttribute("userinfos",listsus);
        return listsus;
    }

    /*//获取用户信息
    @RequestMapping("getsysusers")
    public String getSysUsers(String start, String length,
                              HttpServletRequest reqeust, Model model) {
        //获取datatable的排序参数
        String order = reqeust.getParameter("order[0][column]");
        String orderdir = reqeust.getParameter("order[0][dir]");
        String ordercolumn = reqeust.getParameter("columns[" + order + "][data]");

        List<User> listsus = sus.getSysUsers(start, length, ordercolumn, orderdir);
        model.addAttribute("listsus", listsus);
        return "sysuser";

    }*/

    @RequestMapping("updateusermess")
    @ResponseBody
    @ALog(desc="修改用户")
    //更新用户信息
    public int updateUserMess(@RequestParam(value = "uid") int uid, String username,
                                  String password, String email, String phone, String signed) {

        return sus.updateUserMess(uid, username, password, email, phone,signed);

    }

    //删除用户信息
    @RequestMapping("deleteusermess")
    @ResponseBody
    @ALog(desc="删除用户")
    public int deleteUserMess(@RequestParam(value = "uid") int uid) {
        return sus.deleteUserMess(uid);

    }

    //新增用户数据
    @RequestMapping("addusermess")
    @ResponseBody
    @ALog(desc="新增用户")
    public int addUserMess(User su) throws UnsupportedEncodingException {
        return userLoginService.getRegister(su);
    }

    //验证手机号是否存在
    @RequestMapping("userphoneyanzheng")
    @ResponseBody
    public Map<String, Boolean> getUserPhoneYanZheng(String phone) {
        boolean jieguo = sus.getUserPhoneYanZheng(phone);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", jieguo);
        return map;
    }
}
