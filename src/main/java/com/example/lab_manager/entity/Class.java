package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("class")
public class Class {

    private int class_id;

    private String class_name;

    private int teacher_id;

    private int department_id;

    private int stu_num;

    public Class(String class_name,int teacher_id,int department_id,int stu_num) {
        this.teacher_id = teacher_id;
        this.class_name = class_name;
        this.department_id = department_id;
        this.stu_num = stu_num;
    }
//
//    public Class(int class_id,String class_name,int teacher_id,int department_id,int stu_num) {
//        this.class_id = class_id;
//        this.teacher_id = teacher_id;
//        this.class_name = class_name;
//        this.department_id = department_id;
//        this.stu_num = stu_num;
//    }
}
