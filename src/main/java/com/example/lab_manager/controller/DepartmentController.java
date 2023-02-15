package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Department;
import com.example.lab_manager.entity.Software;
import com.example.lab_manager.service.IDepartmentService;
import com.example.lab_manager.service.ISoftwareService;
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
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    ResultsUtils resultsUtils;


    @RequestMapping("toAdd")
    public String toAdd() {
        return "department/departmentAdd";
    }

    @RequestMapping("toEdit/{department_id}")
    public String toEdit(Model model, @PathVariable("department_id") String department_id) {
        model.addAttribute("department", departmentService.getDepartmentById(Integer.valueOf(department_id)));
        return "department/departmentUpdate";
    }

    @RequestMapping("departmentList")
    public String userList(Model model) {
        model.addAttribute("departmentList", departmentService.listDepartments());
        return "department/departmentList";
    }
    @RequestMapping("departmentAdd")
    @ResponseBody
    public Map<String, String> departmentAdd(@RequestParam("department_name") String department_name) {
        Department department = new Department(department_name);
        int flag = departmentService.saveDepartment(department);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("departmentEdit")
    @ResponseBody
    public Map<String, String> departmentEdit(@RequestParam("department_id") String department_id,
                                           @RequestParam("department_name") String department_name) {
        Department department = new Department(Integer.valueOf(department_id),department_name);
        int flag = departmentService.updateDepartment(department);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("departmentDel")
    @ResponseBody
    public Map<String, String> departmentDel(@RequestParam("department_id") String department_id) {
        int flag = departmentService.deleteDepartment(Integer.valueOf(department_id));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }
}
