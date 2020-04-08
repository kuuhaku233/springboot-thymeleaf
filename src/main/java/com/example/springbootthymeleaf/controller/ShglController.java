package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.service.CkglService;
import com.example.springbootthymeleaf.service.ShglService;
import com.example.springbootthymeleaf.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ShglController extends BaseController{
    @Autowired
    ShglService shglService;
    @Autowired
    HttpSession httpSession;

    @ALog(desc="查询货物信息")
    @RequestMapping("/selectshxx")
    @ResponseBody
    public List<Map<String,Object>> selecck()
    {
        return shglService.selectAll();
    }

    @ALog(desc="签收货物")
    @RequestMapping("/qs")
    @ResponseBody
    public Boolean UpdateByCkId(HttpServletRequest request)
    {
        int  qhm = (int) httpSession.getAttribute("qhm");
        Map<String, Object> params = getParams(request);
        String qhm1 = (String) params.get("qhm");
        int m=Integer.parseInt(qhm1);
        Boolean aBoolean = shglService.qs(params);
        if(aBoolean==true && qhm==m)
        {
            return true;
        }
        return false;
    }

    @ALog(desc="添加收货信息")
    @RequestMapping("/addshxx")
    @ResponseBody
    public Boolean addShxx(HttpServletRequest request)
    {
        int qhm= (int) ((Math.random()*9+1)*100000);
        httpSession.setAttribute("qhm", qhm);
        Map<String, Object> params = getParams(request);
        String email= (String) params.get("email");
        EmailUtil emailUtil=new EmailUtil(email,qhm);
        Boolean aBoolean = shglService.addShxx(params);
        return aBoolean;
    }


    /*@ALog(desc="新增出库信息")
    @RequestMapping("/addckxx")
    @ResponseBody
    public Boolean addCkxx(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.addCkxx(params);
        return aBoolean;
    }

    @ALog(desc="删除出库信息")
    @RequestMapping("/delckxx")
    @ResponseBody
    public Boolean delCkxx(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.delCkxx(params);
        return aBoolean;
    }

    @ALog(desc="提交出库信息")
    @RequestMapping("/updateck")
    @ResponseBody
    public Boolean updateCk(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.updateCk(params);
        return aBoolean;
    }*/





}
