package com.hs.springboot.confing;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*@ControllerAdvice*/
public class GlobalException {
    /*@ExceptionHandler(value = {Exception.class})*/
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e.getMessage());//设置异常信息
        modelAndView.addObject("url",request.getRequestURL());//设置异常路径
        modelAndView.setViewName("error");//设置视图页面
        return modelAndView;
    }
}

