package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.BuildingMapper;
import com.example.lab_manager.dao.ComputerMapper;
import com.example.lab_manager.entity.Building;
import com.example.lab_manager.entity.Computer;
import com.example.lab_manager.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    ComputerMapper computerMapper;


    @Override
    public List<Computer> listComputers() {
        return computerMapper.listComputers();
    }

    @Override
    public Computer getComputerById(int computer_id){
        return computerMapper.getComputerById(computer_id);
    }

    @Override
    public int saveComputer(Computer computer){
        return computerMapper.saveComputer(computer);
    }

    @Override
    public int updateComputer(Computer computer){
        return computerMapper.updateComputer(computer);
    }

    @Override
    public int deleteComputer(int computer_id){
        return computerMapper.deleteComputer(computer_id);
    }

}
