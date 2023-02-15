package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.LabMapper;
import com.example.lab_manager.dao.SoftwareMapper;
import com.example.lab_manager.entity.Class;
import com.example.lab_manager.entity.Software;
import com.example.lab_manager.entity.bo.LabBO;
import com.example.lab_manager.service.ISoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareService implements ISoftwareService {

    @Autowired
    SoftwareMapper softwareMapper;

    @Override
    public List<Software> listSoftware(){
        return softwareMapper.listSoftware();
    }

    @Override
    public Software getSoftwareById(int software_id){
        return softwareMapper.getSoftwareById(software_id);
    }

    @Override
    public int saveSoftware(Software software){
        return softwareMapper.saveSoftware(software);
    }

    @Override
    public int updateSoftware(Software software){
        return softwareMapper.updateSoftware(software);
    }

    @Override
    public int deleteSoftware(int software_id){
        return softwareMapper.deleteSoftware(software_id);
    }
}
