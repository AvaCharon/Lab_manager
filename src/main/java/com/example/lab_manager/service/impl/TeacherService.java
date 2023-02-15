package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.LabMapper;
import com.example.lab_manager.dao.TeacherMapper;
import com.example.lab_manager.entity.Teacher;
import com.example.lab_manager.entity.bo.LabBO;
import com.example.lab_manager.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> listTeachers(){
        return teacherMapper.listTeachers();
    }

    @Override
    public Teacher getTeacherById(int teacher_id){
        return teacherMapper.getTeacherById(teacher_id);
    }

    @Override
    public int saveTeacher(Teacher teacher){
        return teacherMapper.saveTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher){
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int teacher_id){
        return teacherMapper.deleteTeacher(teacher_id);
    }
}
