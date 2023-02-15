package com.example.lab_manager.service;

import com.example.lab_manager.entity.Admin;

import java.util.List;

public interface IAdminService {

    List<Admin> listAdmins();

    Admin getAdminById(int teacher_id);

    int saveAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(int teacher_id);
}
