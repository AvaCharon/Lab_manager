package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.ClassMapper;
import com.example.lab_manager.dao.LabMapper;
import com.example.lab_manager.entity.Class;
import com.example.lab_manager.entity.bo.LabBO;
import com.example.lab_manager.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {


    @Autowired
    ClassMapper classMapper;

    @Override
    public List<Class> listClasses(){
        return classMapper.listClasses();
    }

    @Override
    public Class getClassById(int class_id){
        return classMapper.getClassById(class_id);
    }

    @Override
    public int addClass(Class class_){
        return classMapper.addClass(class_);
    }

    @Override
    public int addClassSoftware(Class class_){
        return classMapper.addClassSoftware(class_);
    }

    @Override
    public int updateClass(Class class_){
        return classMapper.updateClass(class_);
    }

    @Override
    public int deleteClass(int class_id){
        return classMapper.deleteClass(class_id);
    }
}
