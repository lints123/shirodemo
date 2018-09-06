package com.ssm.shirodemo.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(String userName, String password, Model model){
        System.out.println("UserController.login");
        String url = "/index";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        if(userName == null && password == null){
            return "/login";
        }
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("UnknownAccountException -- > 账号不存在：");
            model.addAttribute("msg","account error");
            url = "/login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
            model.addAttribute("msg","password error");
            url = "/login";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception -- > 异常信息："+e.getMessage());
            url = "/login";
        }
        return url;
    }

    @RequestMapping("/userInfo")
    @RequiresPermissions("user:info")
    @ResponseBody
    public String userInfo(){
        System.out.println("userInfo -- > userInfo()");
        return "userInfo";
    }

    @RequestMapping("/userAdd")
    @RequiresPermissions("user:add")
    @ResponseBody
    public String userAdd(){
        System.out.println("userAdd -- > userAdd()");
        return "userAdd";
    }

    @RequestMapping("/userEdit")
    @RequiresPermissions("user:edit")
    @ResponseBody
    public String userEdit(){
        System.out.println("userEdit -- > userEdit()");
        return "userEdit";
    }

    @RequestMapping("/userView")
    @RequiresPermissions("user:view")
    @ResponseBody
    public String userView(){
        System.out.println("userView -- > userView()");
        return "userView";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("user:del")
    @ResponseBody
    public String userDel(){
        System.out.println("userDel -- > userDel()");
        return "userDel";
    }

}
