package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysRoleService;
import com.example.springbootthymeleaf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/link/")
public class LinkController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletResponse response;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/toindex")
    public String getIndex() throws IOException {
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "index";
    }

    @RequestMapping("/tosyspower")
    public String getSysPower() throws IOException {
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/syspower";
    }

    @RequestMapping("/tosysuser")
    public String getSysUser() {
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/sysuser";
    }

    @RequestMapping("/tosysresource")
    public String getSysResource() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/sysresource";
    }

    @RequestMapping("/tosysrole")
    public String getSysRole() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/sysrole";
    }
   /* @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }*/

    @RequestMapping("logout")
    public String SysLogOut (HttpSession session) throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        session.removeAttribute("user");
        return "/login";
    }


    @RequestMapping("/tonopower")
    public String getNopower() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "nopower";
    }

    @RequestMapping("/tomap")
    public String getMap() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "map";
    }

    @RequestMapping("/register")
    public ModelAndView Register() throws IOException{
        ModelAndView mv=new ModelAndView();
        List<Role> roles = sysRoleService.getRoles();
        Map<String,Object> map=new HashMap<>();
        map.put("roles",roles);
        mv.addAllObjects(map);
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/tologs")
    public String getLogs() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/syslog";
    }
    @RequestMapping("/torkgl")
    public ModelAndView getRkgl(){
        ModelAndView mv=new ModelAndView();
        if(session.getAttribute("user")==null)
        {
            mv.setViewName("login");
            return mv;
        }
        List<User> sysUsers = sysUserService.getSysUsers("", "", "", "");
        mv.setViewName("server/rkgl");
        mv.addObject("rkr",sysUsers);
        return mv;
    }

    @RequestMapping("/tockgl")
    public ModelAndView getCkgl(){
        ModelAndView mv=new ModelAndView();
        if(session.getAttribute("user")==null)
        {
            mv.setViewName("login");
            return mv;
        }
        List<User> sysUsers = sysUserService.getSysUsers("", "", "", "");
        mv.setViewName("server/ckgl");
        mv.addObject("rkr",sysUsers);
        return mv;
    }

    @RequestMapping("/tosmqsl")
    public ModelAndView toSmqs(){
        ModelAndView mv=new ModelAndView();
        if(session.getAttribute("user")==null)
        {
            mv.setViewName("login");
            return mv;
        }
        List<User> sysUsers = sysUserService.getSysUsers("", "", "", "");
        mv.setViewName("user/smqj");
        mv.addObject("rkr",sysUsers);
        return mv;
    }

    @RequestMapping("/towyfh")
    public ModelAndView toWyfh(){
        ModelAndView mv=new ModelAndView();
        if(session.getAttribute("user")==null)
        {
            mv.setViewName("login");
            return mv;
        }
        List<User> sysUsers = sysUserService.getSysUsers("", "", "", "");
        mv.setViewName("user/wyfh");
        mv.addObject("rkr",sysUsers);
        return mv;
    }


}
