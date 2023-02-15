package com.example.lab_manager.service;

import com.example.lab_manager.entity.Class;
import com.example.lab_manager.entity.Software;

import java.util.List;

public interface ISoftwareService {
    List<Software> listSoftware();

    Software getSoftwareById(int software_id);

    int saveSoftware(Software software);

    int updateSoftware(Software software);

    int deleteSoftware(int software_id);
}
