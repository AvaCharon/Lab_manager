package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Building;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuildingMapper {

    List<Building> listBuildings();

    Building getBuildingById(int building_id);

    int saveBuilding(Building building);

    int updateBuilding(Building building);

    int deleteBuilding(int building_id);

}