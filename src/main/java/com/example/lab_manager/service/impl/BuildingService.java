package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.BuildingMapper;
import com.example.lab_manager.dao.LabMapper;
import com.example.lab_manager.entity.Building;
import com.example.lab_manager.entity.bo.LabBO;
import com.example.lab_manager.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    BuildingMapper buildingMapper;

    @Override
    public List<Building> listBuildings() {
        return buildingMapper.listBuildings();
    }

    @Override
    public Building getBuildingById(int building_id) {
        return buildingMapper.getBuildingById(building_id);
    }

    @Override
    public int saveBuilding(Building admin){
        return buildingMapper.saveBuilding(admin);
    }

    @Override
    public int updateBuilding(Building admin){
        return buildingMapper.updateBuilding(admin);
    }

    @Override
    public int deleteBuilding(int building_id){
        return buildingMapper.deleteBuilding(building_id);
    }
}
