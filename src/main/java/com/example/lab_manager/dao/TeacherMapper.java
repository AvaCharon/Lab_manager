package com.example.lab_manager.dao;


import com.example.lab_manager.entity.Admin;
import com.example.lab_manager.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> listTeachers();

    Teacher getTeacherById(int teacher_id);

    int saveTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(int teacher_id);

}