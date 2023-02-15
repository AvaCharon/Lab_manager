package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Class;
import com.example.lab_manager.entity.Department;
import com.example.lab_manager.service.IClassService;
import com.example.lab_manager.service.IDepartmentService;
import com.example.lab_manager.service.ITeacherService;
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
@RequestMapping("class")
public class ClassController {

    @Autowired
    IClassService classService;
    @Autowired
    ITeacherService teacherService;
    @Autowired
    IDepartmentService departmentService;

    ResultsUtils resultsUtils;


    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("teacherList", teacherService.listTeachers());
        model.addAttribute("departmentList", departmentService.listDepartments());
        return "class/classAdd";
    }

    @RequestMapping("toEdit/{class_id}")
    public String toEdit(Model model, @PathVariable("class_id") String class_id) {
        model.addAttribute("class", classService.getClassById(Integer.valueOf(class_id)));
        model.addAttribute("teacherList", teacherService.listTeachers());
        model.addAttribute("departmentList", departmentService.listDepartments());
        return "class/classUpdate";
    }

    @RequestMapping("classList")
    public String userList(Model model) {
        model.addAttribute("classList", classService.listClasses());
        return "class/classList";
    }
    @RequestMapping("classAdd")
    @ResponseBody
    public Map<String, String> departmentAdd(@RequestParam("class_name") String class_name,
                                             @RequestParam("teacher_id") String teacher_id,
                                             @RequestParam("department_id") String department_id,
                                             @RequestParam("stu_num") String stu_num) {
        Class class_ = new Class(class_name,Integer.valueOf(teacher_id),Integer.valueOf(department_id),Integer.valueOf(stu_num));
        int flag = classService.addClass(class_);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("classEdit")
    @ResponseBody
    public Map<String, String> departmentEdit(@RequestParam("class_id") String class_id,
                                              @RequestParam("class_name") String class_name,
                                              @RequestParam("teacher_id") String teacher_id,
                                              @RequestParam("department_id") String department_id,
                                              @RequestParam("stu_num") String stu_num) {
        Class class_ = new Class(Integer.valueOf(class_id),class_name,Integer.valueOf(teacher_id),Integer.valueOf(department_id),Integer.valueOf(stu_num));
        int flag = classService.updateClass(class_);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("classDel")
    @ResponseBody
    public Map<String, String> departmentDel(@RequestParam("class_id") String class_id) {
        int flag = classService.deleteClass(Integer.valueOf(class_id));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }
}
