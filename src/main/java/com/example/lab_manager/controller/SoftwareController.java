package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Software;
import com.example.lab_manager.entity.Teacher;
import com.example.lab_manager.service.ISoftwareService;
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
@RequestMapping("software")
public class SoftwareController {

    @Autowired
    ISoftwareService softwareService;

    ResultsUtils resultsUtils;


    @RequestMapping("toAdd")
    public String toAdd() {
        return "software/softwareAdd";
    }

    @RequestMapping("toEdit/{software_id}")
    public String toEdit(Model model, @PathVariable("software_id") String software_id) {
        model.addAttribute("software", softwareService.getSoftwareById(Integer.valueOf(software_id)));
        return "software/softwareUpdate";
    }

    @RequestMapping("softwareList")
    public String userList(Model model) {
        model.addAttribute("softwareList", softwareService.listSoftware());
        return "software/softwareList";
    }
    @RequestMapping("softwareAdd")
    @ResponseBody
    public Map<String, String> softwareAdd(@RequestParam("software_name") String software_name,
                                           @RequestParam("edition") String edition) {
        Software software = new Software(software_name,edition);
        int flag = softwareService.saveSoftware(software);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }
    }

    @RequestMapping("softwareEdit")
    @ResponseBody
    public Map<String, String> softwareEdit(@RequestParam("software_id") String software_id,
                                           @RequestParam("software_name") String software_name,
                                           @RequestParam("edition") String edition) {
        Software software = new Software(Integer.valueOf(software_id),software_name,edition);
        int flag = softwareService.updateSoftware(software);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("softwareDel")
    @ResponseBody
    public Map<String, String> softwareDel(@RequestParam("software_id") String software_id) {
        int flag = softwareService.deleteSoftware(Integer.valueOf(software_id));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }
    }
}
