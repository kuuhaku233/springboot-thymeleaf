package com.example.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/link/")
public class LinkController {

    @RequestMapping("/toindex")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("/tosyspower")
    public String getSysPower(){
        return "/system/syspower";
    }
    @RequestMapping("/tosysuser")
    public String getSysUser(){
        return "/system/sysuser";
    }
    @RequestMapping("/tosysresource")
    public String getSysResource(){
        return "/system/sysresource";
    }
    @RequestMapping("/tosysrole")
    public String getSysRole(){
        return "/system/sysrole";
    }
   /* @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }*/

    @RequestMapping("logout")
    public String SysLogOut(HttpSession session){
        session.removeAttribute("user");
        return "/login";
    }


    @RequestMapping("/tonopower")
    public String getNopower(){
        return "nopower";
    }

    @RequestMapping("/tomap")
    public String getMap(){
        return "map";
    }

    @RequestMapping("/register")
    public String Register(){
        return "register";
    }

    @RequestMapping("/tologs")
    public String getLogs(){
        return "/system/syslog";
    }


}
