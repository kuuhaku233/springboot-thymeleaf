package com.example.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/link/")
public class LinkController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletResponse response;

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
    public String Register() throws IOException{
        return "register";
    }

    @RequestMapping("/tologs")
    public String getLogs() throws IOException{
        if(session.getAttribute("user")==null)
        {
            return "login";
        }
        return "/system/syslog";
    }


}
