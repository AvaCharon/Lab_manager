package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("lab")
public class Lab {

    private int lab_id; // 编号

    private int adm_id; // 实验室管理员

    private int comp_id; // 电脑配置编号

    private int building_id; // 教学楼编号

    private String lab_addr; // 实验室地址

    private  int comp_num; // 电脑台数

    private int status; // 状态

    private int class_id; // 正在使用的课程编号

    private int user_id; // 正在使用的用户编号


    public Lab(int adm_id,int comp_id,int building_id,String lab_addr, int comp_num) {
        this.lab_addr = lab_addr;
        this.building_id = building_id;
        this.adm_id = adm_id;
        this.comp_id = comp_id;
        this.comp_num = comp_num;
    }

    public Lab(int lab_id, int adm_id,int comp_id,int building_id,String lab_addr, int comp_num) {
        this.lab_id = lab_id;
        this.lab_addr = lab_addr;
        this.building_id = building_id;
        this.adm_id = adm_id;
        this.comp_id = comp_id;
        this.comp_num = comp_num;
    }
}