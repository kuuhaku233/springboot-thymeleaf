package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.service.CkglService;
import com.example.springbootthymeleaf.service.RkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class CkglController extends BaseController {
    @Autowired
    CkglService ckglService;

    @ALog(desc = "查询出库信息")
    @RequestMapping("/selecck")
    @GetMapping("/selecck")
    public List<Map<String, Object>> selecck() {
        return ckglService.selecck();
    }

    @ALog(desc = "修改出库信息")
    @RequestMapping("/updateckxx")
    @PutMapping("/updateckxx")
    public Boolean UpdateByCkId(HttpServletRequest request) {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.UpdateById(params);
        return aBoolean;
    }

    @ALog(desc = "新增出库信息")
    @RequestMapping("/addckxx")
    public Boolean addCkxx(HttpServletRequest request) {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.addCkxx(params);
        return aBoolean;
    }

    @ALog(desc = "删除出库信息")
    @RequestMapping("/delckxx")
    public Boolean delCkxx(HttpServletRequest request) {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.delCkxx(params);
        return aBoolean;
    }

    @ALog(desc = "提交出库信息")
    @RequestMapping("/updateck")
    public Boolean updateCk(HttpServletRequest request) {
        Map<String, Object> params = getParams(request);
        Boolean aBoolean = ckglService.updateCk(params);
        return aBoolean;
    }


}
