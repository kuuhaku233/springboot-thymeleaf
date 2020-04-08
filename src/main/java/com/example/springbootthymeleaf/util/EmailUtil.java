package com.example.springbootthymeleaf.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class EmailUtil {
    public EmailUtil(String email,int qhm) {
        //做链接前的准备工作  也就是参数初始化
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.qq.com");//发送邮箱服务器
        properties.setProperty("mail.smtp.port", "465");//发送端口
        properties.setProperty("mail.smtp.auth", "true");//是否开启权限控制
        properties.setProperty("mail.debug", "true");//true 打印信息到控制台
        properties.setProperty("mail.transport", "smtp");//发送的协议是简单的邮件传输协议
        properties.setProperty("mail.smtp.ssl.enable", "true");
        //建立两点之间的链接
        System.out.println("执行了2");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2889388182@qq.com", "rdozwdxhjvpzdcje");
            }
        });
        System.out.println("执行了3");
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress("2889388182@qq.com"));

            //设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//收件人
            //设置主题
            message.setSubject("取货码");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent("您的取货码是"+qhm, "text/html;charset=UTF-8");
            //发送一封邮件
            Transport transport = session.getTransport();
            transport.connect("2889388182@qq.com", "rdozwdxhjvpzdcje");
            Transport.send(message);
            System.out.println("执行了");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public static void main(String[] args) {
        System.out.println("执行了1");
//        EmailUtil emailUtil=new EmailUtil("2889388182@qq.com");
    }
}

