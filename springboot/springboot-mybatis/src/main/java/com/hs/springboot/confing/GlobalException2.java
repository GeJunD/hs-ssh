package com.hs.springboot.confing;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException2 {

    @ExceptionHandler(value = {Exception.class})
    public Object exceptionHandler(HttpServletRequest request,Exception e){
        if(isAjax(request)){
            Map<String,Object> map = new LinkedHashMap<String, Object>();
            map.put("exception",e.getMessage());//设置异常信息
            map.put("url",request.getRequestURL());//设置异常路径
            map.put("success",false);//设置验证状态JSON.toJSONString(map)
            return JSON.toJSONString(map);
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception",e.getMessage());//设置异常信息
            modelAndView.addObject("url",request.getRequestURL());//设置异常路径
            modelAndView.setViewName("test");//设置视图名称
            return modelAndView;
        }
    }

    /**
     * 判断是否是Ajax异步提交
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}

