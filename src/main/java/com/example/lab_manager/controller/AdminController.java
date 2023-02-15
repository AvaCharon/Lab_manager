package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.service.IAdminService;
import com.example.lab_manager.utils.ResultsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    ResultsUtils resultsUtils;

    @RequestMapping("toAdd")
    public String toAdd() {
        return "admin/adminAdd";
    }

    @RequestMapping("toEdit/{teacher_id}")
    public String toEdit(Model model, @PathVariable("teacher_id") String teacher_id) {
        model.addAttribute("admin", adminService.getAdminById(Integer.valueOf(teacher_id)));
        return "admin/adminUpdate";
    }

    @RequestMapping("adminList")
    public String adminList(Model model) {
        model.addAttribute("adminList", adminService.listAdmins());
        return "admin/adminList";
    }

    @RequestMapping("adminAdd")
    @ResponseBody
    public Map<String, String> adminAdd(@RequestParam("teacher_id") String teacher_id,
                                        @RequestParam("password") String password) {
        Admin admin = new Admin(Integer.valueOf(teacher_id), password);
        int flag = adminService.saveAdmin(admin);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("adminEdit")
    @ResponseBody
    public Map<String, String> adminEdit(@RequestParam("teacher_id") String teacher_id,
                                         @RequestParam("password") String password) {
        Admin admin = new Admin(Integer.valueOf(teacher_id), password);
        int flag = adminService.updateAdmin(admin);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("adminDel")
    @ResponseBody
    public Map<String, String> adminDel(@RequestParam("teacher_id") String teacher_id) {
        int flag = adminService.deleteAdmin(Integer.valueOf(teacher_id));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }

}