package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("software")
public class Software {

    private int software_id;

    private String software_name;

    private String edition;

    public Software(String software_name,String edition) {
        this.edition = edition;
        this.software_name = software_name;
    }

    public Software(String software_name) {
        this.software_name = software_name;
    }
}

