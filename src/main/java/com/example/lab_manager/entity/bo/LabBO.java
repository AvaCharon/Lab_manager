package com.example.lab_manager.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabBO {
    private int lab_id; // 编号

    private int adm_id; // 实验室管理员

    private int comp_id; // 电脑配置编号

    private int building_id; // 教学楼编号

    private int class_id; // 正在使用的课程编号

    private int user_id; // 正在使用的用户编号

    private String lab_addr; // 实验室地址

    private  int comp_num; // 电脑台数

    private int status; // 使用状态
}
