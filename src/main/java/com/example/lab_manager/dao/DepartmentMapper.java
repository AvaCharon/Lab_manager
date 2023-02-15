package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<Department> listDepartments();

    Department getDepartmentById(int department_id);

    int saveDepartment(Department department);

    int updateDepartment(Department department);

    int deleteDepartment(int department_id);
}
