package com.example.lab_manager.service;

import com.example.lab_manager.entity.Computer;
import com.example.lab_manager.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> listDepartments();

    Department getDepartmentById(int department_id);

    int saveDepartment(Department department);

    int updateDepartment(Department department);

    int deleteDepartment(int department_id);
}
