package com.example.springbootthymeleaf.controller;

import com.baidu.ueditor.define.State;
import com.example.springbootthymeleaf.ueditor.importword.ConvertWordToHTML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 将word文档转换为html格式展示
 *
 * @date： 2020/4/2
 * @author: wbx
 */
@Controller
public class ConvertController {
    @RequestMapping("/convert")
    @ResponseBody
    public String Convert2Html(HttpServletRequest request, HttpServletResponse response, MultipartFile upfile) throws Exception {
          if(upfile == null)
          {
              return null;
          }
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        File file = multipartFileToFile(upfile);
        Map<String,Object> conf=new HashMap<>();
        conf.put("importwordActionName","importword");
        conf.put("importwordFieldName","upfile");
        conf.put("importwordMaxSize",4096000);
        conf.put("importwordImgPath","/ueditor/test/{yyyy}{mm}{dd}/");
        conf.put("rootPath",rootPath);
        conf.put("savePath","/ueditor/test/");
//        conf.put("importwordActionName","importword");
        ConvertWordToHTML conv= new ConvertWordToHTML(request,conf);
        State convert = conv.convert();
        // 删除文件转换时下载的临时文件
        delteTempFile(file);
        return convert.toJSONString();

//        Word2HtmlUtil instance = Word2HtmlUtil.getInstance(file);
    }
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

}
