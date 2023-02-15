package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Building;
import com.example.lab_manager.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Class> listClasses();

    Class getClassById(int class_id);

    int addClass(Class class_);

    int addClassSoftware(Class class_);

    int updateClass(Class class_);

    int deleteClass(int class_id);

}