package com.example.springbootthymeleaf.controller;

import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController
{
    protected Map<String,Object> getParams(HttpServletRequest request)
    {
        Map<String,Object> map=new HashMap<>();
        Enumeration<String> paras=request.getParameterNames();
        while(paras.hasMoreElements())
        {
           String par=paras.nextElement();
           map.put(par, request.getParameter(par));
        }
        return map;
    }
}
