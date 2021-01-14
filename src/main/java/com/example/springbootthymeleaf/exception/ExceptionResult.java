package com.example.springbootthymeleaf.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @date： 2021/1/14
 * @author: wbx
 *  全局异常返回
 */

@RestControllerAdvice
@Slf4j
public class ExceptionResult {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public Map<String, Object> handleParameterVerificationException(Exception e) {
        log.error(" handleParameterVerificationException has been invoked", e);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("code", "500");
        String msg = null;
        /// BindException
        if (e instanceof BindException) {
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            FieldError fieldError = ((BindException) e).getFieldError();
            if (fieldError != null) {
                msg = fieldError.getDefaultMessage();
            }
            /// MethodArgumentNotValidException
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                msg = fieldError.getDefaultMessage();
            }
            /// ValidationException 的子类异常ConstraintViolationException
        } else if (e instanceof ConstraintViolationException) {
            /*
             * ConstraintViolationException的e.getMessage()形如
             *     {方法名}.{参数名}: {message}
             *  这里只需要取后面的message即可
             */
            msg = e.getMessage();
            if (msg != null) {
                int lastIndex = msg.lastIndexOf(':');
                if (lastIndex >= 0) {
                    msg = msg.substring(lastIndex + 1).trim();
                }
            }
            /// ValidationException 的其它子类异常
        } else {
            msg = "处理参数时异常";
        }
        resultMap.put("msg", msg);
        return resultMap;
    }

    @ExceptionHandler({
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class,
            HttpRequestMethodNotSupportedException.class,
            NullPointerException.class
    })

    public Map<String, Object> exceptionHandlers(Exception e) {
        Map<String, Object> result = new HashMap<>();
        log.error(e.getMessage(), e);
        String msg = buildMessage(e);
//        if (ENV_DEV.equals(profile)) {
//            // 当为测试环境,要显示具体的错
//            msg = buildMessage(e);
//        }
        result.put("msg",msg);
        result.put("code",500);
        return result;
    }

    @ExceptionHandler({
            java.net.BindException.class
    })
    public Map<String, Object> exceptionHandler(java.net.BindException e) {
        Map<String, Object> result = new HashMap<>();
        log.error(e.getMessage(), e);
        String msg = buildMessage(e);
//        if (ENV_DEV.equals(profile)) {
//            // 当为测试环境,要显示具体的错
//            msg = buildMessage(e);
//        }
        result.put("msg",msg);
        result.put("code",500);
        return result;
    }

    /**
     * 构建异常信息
     *
     * @param ex
     * @return
     */
    protected String buildMessage(Throwable ex) {
        HttpServletRequest  request = null;
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attrs != null) {
             request  =  attrs.getRequest();
        }
        StringBuilder message = new StringBuilder("请求处理失败 [ ");
        message.append(request.getMethod());
        message.append(" ");
        message.append(request.getRequestURI());
        message.append(" ]");
        if (null != ex && null != ex.getMessage()) {
            message.append(" : ");
            message.append(ex.getMessage());
        }
        return message.toString();
    }
}
