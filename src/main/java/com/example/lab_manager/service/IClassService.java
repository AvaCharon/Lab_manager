package com.example.lab_manager.service;

import com.example.lab_manager.entity.Class;

import java.util.List;

public interface IClassService {

    List<Class> listClasses();

    Class getClassById(int class_id);

    int addClass(Class class_);

    int addClassSoftware(Class class_);

    int updateClass(Class class_);

    int deleteClass(int class_id);

}
