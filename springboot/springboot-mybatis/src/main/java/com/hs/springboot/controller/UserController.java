package com.hs.springboot.controller;

import com.hs.springboot.entity.User;
import com.hs.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView model, User user){

        int count= userService.add(user);
        if (count>0){
            model.setViewName("redirect:touserlist");
        }else{
            model.setViewName("add");
        }

        return model;
    }

    @RequestMapping("/touserlist")
    public ModelAndView userlist(ModelAndView model){
        try {
            List<User> userList=userService.userList();
            model.addObject("userlist", userList);
            model.setViewName("userlist");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @RequestMapping("/delUserById")
    public ModelAndView delUser(ModelAndView model,int id){
        try {
            int count  =  userService.delUser(id);
            /*userlist(model);*/
            model.setViewName("redirect:touserlist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(ModelAndView model,int id){
        try {
            User user  =  userService.toUpdate(id);
            model.addObject("user", user);
            model.setViewName("update");
            /*userlist(model);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(ModelAndView model,User user){
        try {
            int count  =  userService.updateUser(user);

            model.setViewName("redirect:touserlist");

        } catch (Exception e) {
            e.printStackTrace();
        }
       return model;
    }
    @ResponseBody
    @RequestMapping("/exception")
    public String exception(){
        int i = 10/0;
        return "测试异常处理";
    }

    @RequestMapping("/ajaxexception")
    public Object ajaxexception(){
        int i = 10/0;
        return true;
    }
}
