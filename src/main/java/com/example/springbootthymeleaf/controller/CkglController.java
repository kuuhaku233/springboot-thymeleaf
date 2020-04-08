package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.service.CkglService;
import com.example.springbootthymeleaf.service.RkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CkglController extends BaseController{
    @Autowired
    CkglService ckglService;

    @ALog(desc="查询出库信息")
    @RequestMapping("/selecck")
    @ResponseBody
    public List<Map<String,Object>> selecck()
    {
        return ckglService.selecck();
    }

    @ALog(desc="修改出库信息")
    @RequestMapping("/updateckxx")
    @ResponseBody
    public Boolean UpdateByCkId(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.UpdateById(params);
        return aBoolean;
    }

    @ALog(desc="新增出库信息")
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
    }





}
