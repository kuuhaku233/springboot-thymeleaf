package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.pojo.Role;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.SysRoleService;
import com.example.springbootthymeleaf.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = {"/login"})
    public String userLogin(User user, HttpSession sess, Model model) {
        //使用 shiro编写登录操作
        /**
         *  1.获取subject
         */
        Subject subject = SecurityUtils.getSubject();
        // 2.封装 UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 3.执行 Login方法
        try {
            subject.login(token);
            User user1 = userLoginService.findByUsername(user.getUsername());
            sess.setAttribute("user", user1);
            return "index";
            //登录成功
        } catch (UnknownAccountException e) {// 用户名不存在
            e.printStackTrace();
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {// 密码错误
            e.printStackTrace();
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model)
    {
        List<Role> roles = sysRoleService.getRoles();
        model.addAttribute("roles", roles);
        return "/register";
    }
    @PostMapping("/register")
    public String getRegister(User user,Model model) {
        Integer register = userLoginService.getRegister(user);
        if(register>0)
        {
            model.addAttribute("result", "注册成功");
        }
        return "register";
    }

}
