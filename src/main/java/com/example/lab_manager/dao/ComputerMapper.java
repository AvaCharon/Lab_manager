package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Computer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComputerMapper {
    List<Computer> listComputers();

    Computer getComputerById(int computer_id);

    int saveComputer(Computer computer);

    int updateComputer(Computer computer);

    int deleteComputer(int computer_id);
}
