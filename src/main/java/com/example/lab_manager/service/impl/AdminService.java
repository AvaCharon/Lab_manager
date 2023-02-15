package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.AdminMapper;
import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;


    @Override
    public List<Admin> listAdmins() {
        return adminMapper.listAdmins();
    }

    @Override
    public Admin getAdminById(int teacher_id) {
        return adminMapper.getAdminById(teacher_id);
    }

    @Override
    public int saveAdmin(Admin admin) {

        return adminMapper.saveAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int teacher_id) {
        return adminMapper.deleteAdmin(teacher_id);
    }
}
