package com.example.lab_manager.service;

import com.example.lab_manager.entity.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> listTeachers();

    Teacher getTeacherById(int teacher_id);

    int saveTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(int teacher_id);
}
