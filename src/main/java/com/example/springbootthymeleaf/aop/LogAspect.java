package com.example.springbootthymeleaf.aop;

import com.example.springbootthymeleaf.annotation.ALog;
import com.example.springbootthymeleaf.pojo.Log;
import com.example.springbootthymeleaf.pojo.User;
import com.example.springbootthymeleaf.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    LogService logService;
    @Autowired
    HttpServletRequest request;

//    Log log=new Log();

    @Pointcut("@annotation(com.example.springbootthymeleaf.annotation.ALog)")
    public void pointcut() {
    }

    /*@Before("pointcut()")
    public void beforeLog() {
        logger.info("进入切面前的通知");
        Log log=new Log();
        Object result=null;
        long time=System.
        Date begin_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null)
        {
            log.setBegin_time(begin_time);
            log.setUsername(user.getUsername());
            log.setUrl(request.getServerName()+request.getServerPort()+request.getRequestURL());
        }
    }*/
    /*@After("pointcut()")
    public void afterLog()
    {
        Date end_time=new Date();
        logger.info("方法结束后:"+new Date("yyyy-MM-dd HH:mm:ss.SSS").toString());
        User user = (User) request.getSession().getAttribute("user");
        log.setEnd_time(end_time);
        System.out.println(log);
    }
*/
    @Around("pointcut()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable
    {
         Log log=new Log();
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
       ALog aLog=method.getAnnotation(ALog.class);
        // 获取操作描述的属性值
        String desc = aLog.desc();
        log.setTitle(desc);
        User user = (User) request.getSession().getAttribute("user");
        if(user==null)
        {
            return null;
        }

        Object result = null;
        String exception="";
        try {
            //让代理方法执行
            result = point.proceed();
            // 2.相当于后置通知(方法成功执行之后走这里)
            exception="正常";// 设置操作结果
        } catch (Exception e) {
            // 3.相当于异常通知部分
            exception="失败";// 设置操作结果
        } finally {
            log.setUrl(request.getRequestURI().toString());
            log.setUsername(user.getUsername());
            log.setException(exception);
            log.setRoleid(user.getRoleid());
            // 4.相当于最终通知
            log.setEnd_time(new Date());// 设置操作日期
//            logService.saveLog(log);// 添加日志记录
            logService.saveLog(log);
//            System.out.println(log);
        }
        return result;

    }

}
