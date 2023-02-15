package com.example.lab_manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("building")
public class Building {

    private int building_id;

    private String building_name;

    public Building(int building_id) {
        this.building_id = building_id;
    }
}