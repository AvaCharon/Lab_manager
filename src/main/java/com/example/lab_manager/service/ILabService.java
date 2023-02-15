package com.example.lab_manager.service;

import com.example.lab_manager.entity.Lab;
import com.example.lab_manager.entity.bo.LabBO;

import java.util.List;

public interface ILabService {

    List<LabBO> listLabs(); // 获取实验室列表

    List<LabBO> listLabsByAdmin(int adm_id); // 通过管理员编号获取实验室列表

    LabBO getLabById(int lab_id); // 获取实验室信息

    int saveLab(Lab lab);

    int updateLab(Lab lab);

    int updateApplyLab(Lab lab);

    int updateApplyStatus(Lab lab);

    int unpassApplyStatus(Lab lab);

    int deleteLab(int lab_id);

}