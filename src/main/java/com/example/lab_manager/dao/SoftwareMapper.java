package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Class;
import com.example.lab_manager.entity.Software;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SoftwareMapper {

    List<Software> listSoftware();

    Software getSoftwareById(int software_id);

    int saveSoftware(Software software);

    int updateSoftware(Software software);

    int deleteSoftware(int software_id);

}