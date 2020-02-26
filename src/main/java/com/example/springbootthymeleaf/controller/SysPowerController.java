package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.service.SysPowerService;
import com.example.springbootthymeleaf.view.PowerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/system/")
public class SysPowerController {
    @Autowired
    private SysPowerService sysPowerService;


    //获取选中角色锁具有的资源
    @RequestMapping("getpwoerresource")
    @ResponseBody
    @ALog(desc="查看权限")
    public List<PowerVO> getPowerResource(Integer rid)
    {
       return sysPowerService.getPowerResource(rid);
    }

    /**
     *   修改用户所拥有的资源
     * @param rid  用户id
     * @return t/f
     */
    @RequestMapping("updaterolepower")
    @ResponseBody
    @ALog(desc="修改权限")
    public int updateRolePower(@RequestParam(value = "rid", required=false) Integer rid,
                                    HttpServletRequest request)

    {
//        String rid1 = request.getParameter("rid");
        String reids1 = request.getParameter("reids");
        if(("").equals(reids1)||reids1.equals(null))
        {
            return 0;
        }
        String[] arr = reids1.split(",");
        return sysPowerService.updateRolePower(rid, arr);
    }
    @RequestMapping("deleteResourceByRid")
    @ResponseBody
    public int deleteResourceByRid(Integer rid)
    {
        return sysPowerService.deleteResourceByRid(rid);
    }

}
