package com.example.lab_manager.service;

import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Building;

import java.util.List;

public interface IBuildingService {

    List<Building> listBuildings();

    Building getBuildingById(int building_id);

    int saveBuilding(Building admin);

    int updateBuilding(Building admin);

    int deleteBuilding(int building_id);
}
