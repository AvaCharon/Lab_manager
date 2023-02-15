package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Teacher;
import com.example.lab_manager.entity.User;
import com.example.lab_manager.service.IAdminService;
import com.example.lab_manager.service.ITeacherService;
import com.example.lab_manager.service.IUserService;
import com.example.lab_manager.utils.ResultsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    IAdminService adminService;
    @Autowired
    IUserService userService;

    ResultsUtils resultsUtils;

    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("loginTest")
    @ResponseBody
    @CrossOrigin("*")
    public Map<String, String> loginTest(@RequestBody Admin admin){
        System.out.println("admin==>"+admin.toString());
        return resultsUtils.resultsMap("success", "测试成功！");
    }



    @RequestMapping("login/check")
    @ResponseBody
    public Map<String, String> check(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("type") String type,
                                     HttpSession session) {
        //System.out.println("type"+type);
        if (type.equals("0")) {
            Admin admin = adminService.getAdminById(Integer.valueOf(username));
            if (admin != null) {
                if (admin.getA_password().equals(password)) {
                    session.setAttribute("type", type);
                    session.setAttribute("admin", admin);
                    return resultsUtils.resultsMap("success", "登录成功！");
                } else {
                    return resultsUtils.resultsMap("error", "密码错误！");
                }
            } else {
                return resultsUtils.resultsMap("error", "账户不存在！");
            }

        }
        if (type.equals("1")) {
            User user = userService.getUserByTeacherId(Integer.valueOf(username));
            if (user != null) {
                if (user.getU_password().equals(password)) {
                    session.setAttribute("type", type);
                    session.setAttribute("user", user);
                    return resultsUtils.resultsMap("success", "登录成功！");
                } else {
                    return resultsUtils.resultsMap("error", "密码错误！");
                }
            } else {
                return resultsUtils.resultsMap("error", "账户不存在！");
            }
        }

        return resultsUtils.resultsMap("error", "未选择角色！");

    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("type");
        return "redirect:http://localhost:8080";
    }


}
