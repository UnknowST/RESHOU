package com.controller;

import com.daomain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.Userservice;
import com.service.impl.UserserviceImpl;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends com.controller.Controller {
    @Autowired
    private Userservice userservice=new UserserviceImpl();
    @RequestMapping("/read")
    public ModelAndView save(){
        ModelAndView modelAndView=new ModelAndView();
        List<User> list=userservice.findall();
        modelAndView.addObject("userlist",list);
        modelAndView.setViewName("First");
        return modelAndView;

    }
    @RequestMapping("/list")
    @ResponseBody
    public String read() throws JsonProcessingException {
        List<User> list=userservice.findall();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        return s;

    }
    @RequestMapping("/save")
    public ModelAndView saveuser(User user){
        userservice.save(user);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/test")
    public void  test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String statu=null;
        if (user!=null){
            statu="success";

        }
        else {
            statu="fail";
        }
        writeValue(statu,response);

    }
    @RequestMapping("/test2")
    @ResponseBody
    /*返回数据为json格式*/
    public Map<String, Integer> test2(){
        Map<String ,Integer> map=new HashMap<>();
        map.put("one",1);
        map.put("tow",2);
        return map;
    }

    @RequestMapping("/test3")
    @ResponseBody

    /*返回数据为json格式*/
    public List<User> test3(){
        List<User> list=userservice.findall();
        return list;
    }

}
