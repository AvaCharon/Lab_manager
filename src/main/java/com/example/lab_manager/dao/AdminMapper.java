package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> listAdmins();

    Admin getAdminById(int adm_id);

    int saveAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(int adm_id);

}