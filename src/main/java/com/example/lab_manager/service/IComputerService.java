package com.example.lab_manager.service;

import com.example.lab_manager.entity.Building;
import com.example.lab_manager.entity.Computer;

import java.util.List;

public interface IComputerService {

    List<Computer> listComputers();

    Computer getComputerById(int computer_id);

    int saveComputer(Computer computer);

    int updateComputer(Computer computer);

    int deleteComputer(int computer_id);
}
