package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.FhglService;
import com.example.springbootthymeleaf.service.ShglService;
import com.example.springbootthymeleaf.util.EmailUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class FhglController extends BaseController{
    @Autowired
    FhglService fhglService;
    @Autowired
    HttpSession httpSession;

    @ALog(desc="查询发货订单")
    @RequestMapping("/selectfhxx")
    @ResponseBody
    public List<Map<String,Object>> selecck()
    {
        return fhglService.listAll();
    }

    @ALog(desc="添加发货信息")
    @RequestMapping("/insertYj")
    @ResponseBody
    public Boolean insertYj(HttpServletRequest request, HttpSession sess)
    {
        Map<String, Object> params = getParams(request);
        User u= (User) sess.getAttribute("user");
        params.put("tousername",u.getUsername());
        params.put("fromphone",u.getPhone());
        Random random=new Random();
        random.nextLong();
        params.put("danhao", UUID.randomUUID().toString());
        params.put("time",new Date());
        return fhglService.insertYj(params);
    }

    @ALog(desc="删除发货订单")
    @RequestMapping("/deleteYj")
    @ResponseBody
    public Boolean deleteYj(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        return fhglService.deleteYj(params);
    }

    @ALog(desc="确认发货")
    @RequestMapping("/curYj")
    @ResponseBody
    public Boolean curYj (HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        return fhglService.curYj(params);
    }

    @ALog(desc="修改发货信息")
    @RequestMapping("/updateYj")
    @ResponseBody
    public Boolean updateYj (HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        return fhglService.updateYj(params);
    }







}
