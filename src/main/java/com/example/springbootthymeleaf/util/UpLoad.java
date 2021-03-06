package com.example.springbootthymeleaf.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

//文件上传
public class UpLoad {
	
	public  static void upLoad(String realPath, MultipartFile file, String fileName){
		File pathFile = new File(realPath);
		File newFile=new File(realPath+fileName);
		if(!pathFile.exists() ){
			pathFile.mkdirs();
		}
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
			file.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
