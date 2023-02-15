package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("adm")
public class Admin {

    private int adm_id; // 用户名

    private int teacher_id;

    private String a_password; // 密码

    private Timestamp createTime; // 创建时间

    private Timestamp modifyTime; // 更新时间

    public Admin(int teacher_id, String a_password) {
        this.teacher_id = teacher_id;
        this.a_password = a_password;
    }
}