package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.service.CkglService;
import com.example.springbootthymeleaf.service.LogService;
import com.example.springbootthymeleaf.service.RkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class RkglController extends BaseController{
    @Autowired
    RkglService rkglService;
    @Autowired
    CkglService ckglService;
    @Autowired
    LogService logService;
    @ALog(desc="查询入库信息")
    @RequestMapping("/rkgl")
    @ResponseBody
    public List<Map<String,Object>> findAll()
    {
        return rkglService.findAll();
    }


    @ALog(desc="修改入库信息")
    @RequestMapping("/updaterkxx")
    @ResponseBody
    public Boolean UpdateById(HttpServletRequest request)
    {
        Integer id =Integer.parseInt(request.getParameter("id"));
        List<Map<String, Object>> maps = rkglService.selectChange(id);
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = rkglService.UpdateById(params);
        List<Map<String, Object>> newMap = rkglService.selectChange(id);
//        String desc="改变前的"
        return aBoolean;
    }

    @ALog(desc="新增入库信息")
    @RequestMapping("/addrkxx")
    @ResponseBody
    public Boolean addRkxx(HttpServletRequest request)
    {


        Map<String, Object> params = getParams(request);
        Boolean aBoolean = rkglService.addRkxx(params);
        return aBoolean;
    }

    @ALog(desc="删除入库信息")
    @RequestMapping("/delrkxx")
    @ResponseBody
    public Boolean delRkxx(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = rkglService.delRkxx(params);
        return aBoolean;
    }

    @ALog(desc="提交入库信息")
    @RequestMapping("/updaterk")
    @ResponseBody
    public Boolean updateRk(HttpServletRequest request)
    {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = rkglService.updateRk(params);
        Boolean aBoolean1 = ckglService.addCkxx(params);
        return aBoolean1;
    }





}
