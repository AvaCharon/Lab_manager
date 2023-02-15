package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Teacher;
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

import java.util.Map;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    ResultsUtils resultsUtils;


    @RequestMapping("toAdd")
    public String toAdd() {
        return "teacher/teacherAdd";
    }

    @RequestMapping("toEdit/{teacher_id}")
    public String toEdit(Model model, @PathVariable("teacher_id") String teacher_id) {
        model.addAttribute("teacher", teacherService.getTeacherById(Integer.valueOf(teacher_id)));
        return "teacher/teacherUpdate";
    }

    @RequestMapping("teacherList")
    public String userList(Model model) {
        model.addAttribute("teacherList", teacherService.listTeachers());
        return "teacher/teacherList";
    }
    @RequestMapping("teacherAdd")
    @ResponseBody
    public Map<String, String> teacherAdd(@RequestParam("teacherNo") String teacherNo,
                                       @RequestParam("teacherName") String teacherName) {
        Teacher teacher = new Teacher(Integer.valueOf(teacherNo),teacherName);
        int flag = teacherService.saveTeacher(teacher);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("teacherEdit")
    @ResponseBody
    public Map<String, String> teacherEdit(@RequestParam("teacher_id") String teacher_id,
                                        @RequestParam("teacher_name") String teacher_name) {
        Teacher teacher = new Teacher(Integer.valueOf(teacher_id),teacher_name);
        int flag = teacherService.updateTeacher(teacher);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("teacherDel")
    @ResponseBody
    public Map<String, String> teacherDel(@RequestParam("teacherNo") String teacherNo) {
        int flag = teacherService.deleteTeacher(Integer.valueOf(teacherNo));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }
}
