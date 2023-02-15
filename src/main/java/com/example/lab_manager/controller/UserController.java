package com.example.lab_manager.controller;

import com.example.lab_manager.entity.User;
import com.example.lab_manager.service.ITeacherService;
import com.example.lab_manager.service.IUserService;
import com.example.lab_manager.utils.ResultsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    ResultsUtils resultsUtils;

    @RequestMapping("toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("toEdit/{teacherNo}")
    public String toEdit(Model model, @PathVariable("teacherNo") String teacherNo) {
        model.addAttribute("user", userService.getUserByTeacherId(Integer.valueOf(teacherNo)));
        return "user/userUpdate";
    }

    @RequestMapping("userList")
    public String userList(Model model) {
        model.addAttribute("userList", userService.listUsers());
        return "user/userList";
    }

    @RequestMapping("userAdd")
    @ResponseBody
    public Map<String, String> userAdd(@RequestParam("teacherNo") String teacherNo,
                                          @RequestParam("teacherPwd") String teacherPwd) {
        User user = new User(Integer.valueOf(teacherNo),teacherPwd);
        int flag = userService.saveUser(user);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("userEdit")
    @ResponseBody
    public Map<String, String> userEdit(@RequestParam("teacherNo") String teacherNo,
                                           @RequestParam("teacherPwd") String teacherPwd) {
        User user = new User(Integer.valueOf(teacherNo),teacherPwd);
        int flag = userService.saveUser(user);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("userDel")
    @ResponseBody
    public Map<String, String> userDel(@RequestParam("teacherNo") String teacherNo) {
        int flag = userService.deleteUser(Integer.valueOf(teacherNo));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }

}
