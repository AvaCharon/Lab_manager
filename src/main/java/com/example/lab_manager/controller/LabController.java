package com.example.lab_manager.controller;

import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Lab;
import com.example.lab_manager.service.*;
import com.example.lab_manager.utils.ResultsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("lab")
public class LabController {

    @Autowired
    ILabService labService;
    @Autowired
    IAdminService adminService;
    @Autowired
    IBuildingService buildingService;
    @Autowired
    IComputerService computerService;
    @Autowired
    IClassService classService;
    @Autowired
    IUserService userService;

    ResultsUtils resultsUtils;

    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        // 将技术员列表、部门列表传输给页面
        model.addAttribute("adminList", adminService.listAdmins());
        model.addAttribute("buildingList", buildingService.listBuildings());
        model.addAttribute("compList", computerService.listComputers());
        return "lab/labAdd";
    }

    @RequestMapping("toEdit/{lab_id}")
    public String toUpdate(Model model, @PathVariable("lab_id") int lab_id) {
        model.addAttribute("lab", labService.getLabById(lab_id));
        model.addAttribute("adminList", adminService.listAdmins());
        model.addAttribute("buildingList", buildingService.listBuildings());
        model.addAttribute("compList", computerService.listComputers());
        return "lab/labUpdate";
    }

    @RequestMapping("toApplyEdit/{lab_id}")
    public String toApplyUpdate(Model model, @PathVariable("lab_id") int lab_id) {
        model.addAttribute("lab", labService.getLabById(lab_id));
        model.addAttribute("classList", classService.listClasses());
        model.addAttribute("userList", userService.listUsers());
        return "lab/labApplyUpdate";
    }

    @RequestMapping("labList")
    public String labList(Model model) {
        model.addAttribute("labList", labService.listLabs());
        return "lab/labList";
    }

    @RequestMapping("labApplyList")
    public String labApplyList(Model model) {
        model.addAttribute("labList", labService.listLabs());
        return "lab/labApplyList";
    }

    @RequestMapping("labCheckList")
    public String labCheckList(Model model) {
        model.addAttribute("labList", labService.listLabs());
        return "lab/labCheckList";
    }

    @RequestMapping("labByAccountList")
    public String labByAdminList(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("labList", labService.listLabsByAdmin(admin.getAdm_id()));
        return "lab/labByIdList";
    }

    @RequestMapping("labByIdList")
    public String labByIdList(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("labList", labService.listLabsByAdmin(admin.getAdm_id())); // session
        return "assistantRepair/labByIdList";
    }

    @RequestMapping("labAdd")
    @ResponseBody
    public Map<String, String> labAdd(@RequestParam("adm_id") String adm_id,
                                      @RequestParam("comp_id") String comp_id,
                                      @RequestParam("building_id") String building_id,
                                      @RequestParam("lab_addr") String lab_addr,
                                      @RequestParam("comp_num") String comp_num) {

        Lab lab = new Lab(Integer.valueOf(adm_id),Integer.valueOf(comp_id), Integer.valueOf(building_id),lab_addr, Integer.valueOf(comp_num));
        int flag = labService.saveLab(lab);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "添加成功！");
        } else {
            return resultsUtils.resultsMap("error", "添加失败，请联系管理员！");
        }

    }

    @RequestMapping("labEdit")
    @ResponseBody
    public Map<String, String> labEdit(@RequestParam("lab_id") String lab_id,
                                       @RequestParam("adm_id") String adm_id,
                                       @RequestParam("comp_id") String comp_id,
                                       @RequestParam("building_id") String building_id,
                                       @RequestParam("lab_addr") String lab_addr,
                                       @RequestParam("comp_num") String comp_num){

        Lab lab = new Lab(Integer.valueOf(lab_id),Integer.valueOf(adm_id),Integer.valueOf(comp_id), Integer.valueOf(building_id),lab_addr, Integer.valueOf(comp_num));

        int flag = labService.updateLab(lab);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("labApplyEdit")
    @ResponseBody
    public Map<String, String> labApplyEdit(@RequestParam("lab_id") String lab_id,
                                            @RequestParam("adm_id") String adm_id,
                                            @RequestParam("comp_id") String comp_id,
                                            @RequestParam("building_id") String building_id,
                                            @RequestParam("lab_addr") String lab_addr,
                                            @RequestParam("comp_num") String comp_num,
                                            @RequestParam("status") String status,
                                            @RequestParam("class_id") String class_id,
                                            @RequestParam("user_id") String user_id){

        Lab lab = new Lab(Integer.valueOf(lab_id),Integer.valueOf(adm_id),Integer.valueOf(comp_id), Integer.valueOf(building_id),lab_addr, Integer.valueOf(comp_num), Integer.valueOf(status), Integer.valueOf(class_id), Integer.valueOf(user_id));

        int flag = labService.updateApplyLab(lab);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }


    @RequestMapping("labApplyStatusEdit")
    @ResponseBody
    public Map<String, String> labApplyStatusEdit(@RequestParam("lab_id") String lab_id,
                                                @RequestParam("status") String status){
        Lab lab = new Lab();
        lab.setLab_id(Integer.valueOf(lab_id));
        lab.setStatus(Integer.valueOf(status));
        if(lab.getStatus()==0){
            labService.unpassApplyStatus(lab);
        }
        int flag = labService.updateApplyStatus(lab);
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "修改成功！");
        } else {
            return resultsUtils.resultsMap("error", "修改失败，请联系管理员！");
        }
    }

    @RequestMapping("labDel")
    @ResponseBody
    public Map<String, String> labDel(@RequestParam("lab_id") String lab_id) {

        int flag = labService.deleteLab(Integer.valueOf(lab_id));
        if (flag == 1) {
            return resultsUtils.resultsMap("success", "删除成功！");
        } else {
            return resultsUtils.resultsMap("error", "删除失败，请联系管理员！");
        }

    }

}

