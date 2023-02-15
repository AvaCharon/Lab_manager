package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_")
public class User {

    private int user_id; // 用户名

    private int teacher_id;

    private String u_password;

    public User(int teacher_id, String u_password) {
        this.teacher_id = teacher_id;
        this.u_password = u_password;
    }
}
