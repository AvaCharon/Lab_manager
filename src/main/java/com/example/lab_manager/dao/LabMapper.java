package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Lab;
import com.example.lab_manager.entity.bo.LabBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabMapper {

    List<LabBO> listLabs(); // 获取实验室列表

    List<LabBO> listLabsByAdmin(int adm_id); // 根据管理员编号获取所管理实验室

    LabBO getLabById(int lab_id); // 获取实验室信息

    int saveLab(Lab lab);

    int updateLab(Lab lab);

    int updateApplyLab(Lab lab);

    int updateApplyStatus(Lab lab);

    int unpassApplyStatus(Lab lab);

    int deleteLab(int lab_id);

}