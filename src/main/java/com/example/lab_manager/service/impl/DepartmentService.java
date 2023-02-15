package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.ComputerMapper;
import com.example.lab_manager.dao.DepartmentMapper;
import com.example.lab_manager.entity.Computer;
import com.example.lab_manager.entity.Department;
import com.example.lab_manager.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> listDepartments() {
        return departmentMapper.listDepartments();
    }

    @Override
    public Department getDepartmentById(int department_id) {
        return departmentMapper.getDepartmentById(department_id);
    }

    @Override
    public int saveDepartment(Department department) {
        return departmentMapper.saveDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public int deleteDepartment(int department_id) {
        return departmentMapper.deleteDepartment(department_id);
    }
}
