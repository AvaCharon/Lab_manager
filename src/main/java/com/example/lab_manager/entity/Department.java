package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("department")
public class Department {
    private int department_id;

    private String department_name;

    public Department(String department_name) {
        this.department_name = department_name;
    }
}
