package com.example.springbootthymeleaf.util;

import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaMetadataKeys;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date： 2021/1/29
 * @author: wbx
 *  判断文件类型
 */
public class ValFileType {
    /**
     * 获取类型
     * @param file 传入文件
     * @return
     */
    public static String getMimeType(File file) {
        if (file.isDirectory()) {
            return "the target is a directory";
        }

        AutoDetectParser parser = new AutoDetectParser();
        parser.setParsers(new HashMap<MediaType, Parser>());
        Metadata metadata = new Metadata();
        metadata.add(TikaMetadataKeys.RESOURCE_NAME_KEY, file.getName());
        try (InputStream stream = new FileInputStream(file)) {
            parser.parse(stream, new DefaultHandler(), metadata, new ParseContext());
        }catch (Exception e){
            throw new RuntimeException();
        }
        return metadata.get(HttpHeaders.CONTENT_TYPE);
    }

    /**
     * 判断是否是图片
     * @param file
     * @return
     */
    public static boolean isImage(File file){
        // 获取文件真实类型   image/jpeg
        String type = getMimeType(file);
        System.out.println(type);
        Pattern p = Pattern.compile("image/.*");
        Matcher m = p.matcher(type);
        return m.matches();
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "123.jpg");
        boolean flag = isImage(file);
        System.out.println("是否为图片格式" + flag);
    }
}

