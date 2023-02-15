package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.AdminMapper;
import com.example.lab_manager.dao.LabMapper;
import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Lab;
import com.example.lab_manager.entity.bo.LabBO;
import com.example.lab_manager.service.IAdminService;
import com.example.lab_manager.service.ILabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabService implements ILabService {

    @Autowired
    LabMapper labMapper;

    @Override
    public List<LabBO> listLabs() {
        return labMapper.listLabs();
    }

    @Override
    public List<LabBO> listLabsByAdmin(int adm_id) {
        return labMapper.listLabsByAdmin(adm_id);
    }

    @Override
    public LabBO getLabById(int lab_id) {
        return labMapper.getLabById(lab_id);
    }

    @Override
    public int saveLab(Lab lab) {
        return labMapper.saveLab(lab);
    }

    @Override
    public int updateLab(Lab lab){
        return labMapper.updateLab(lab);
    }

    @Override
    public int updateApplyLab(Lab lab){
        return labMapper.updateApplyLab(lab);
    }

    @Override
    public int updateApplyStatus(Lab lab){
        return labMapper.updateApplyStatus(lab);
    }

    @Override
    public int unpassApplyStatus(Lab lab){
        return labMapper.unpassApplyStatus(lab);
    }

    @Override
    public int deleteLab(int lab_id){
        return labMapper.deleteLab(lab_id);
    }
}
