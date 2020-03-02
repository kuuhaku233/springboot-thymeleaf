package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.util.UpLoad;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload/")
public class UploadController {
    @RequestMapping("uploadImages")
    @ResponseBody
    public Map<String, String> uploadImages(HttpServletRequest request,
            @RequestParam(value = "file", required = false) CommonsMultipartFile file) {
        Map<String, String> map = new HashMap<>();
        String uname=String.valueOf(System.currentTimeMillis());
        //获取真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/") + "chanpintubiao/imgs/";
        System.out.println(realPath);
        //文件名
        String oname = file.getOriginalFilename();

        String fileName = uname + oname;

        UpLoad.upLoad(realPath, file, fileName);
        Map<String, String> data = new HashMap<String, String>();
        String srcname = "/static/upload/" + fileName;

        map.put("path", srcname);
        map.put("orname", oname);
        map.put("fileName", fileName);


        return map;


    }
}
