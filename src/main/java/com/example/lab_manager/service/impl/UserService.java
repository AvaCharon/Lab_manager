package com.example.lab_manager.service.impl;

import com.example.lab_manager.dao.TeacherMapper;
import com.example.lab_manager.dao.UserMapper;
import com.example.lab_manager.entity.Teacher;
import com.example.lab_manager.entity.User;
import com.example.lab_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUsers(){
        return userMapper.listUsers();
    }

    @Override
    public User getUserById(int user_id){
        return userMapper.getUserById(user_id);
    }

    @Override
    public User getUserByTeacherId(int teacher_id){
        return userMapper.getUserByTeacherId(teacher_id);
    }

    @Override
    public int saveUser(User user){
        return userMapper.saveUser(user);
    }

    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int teacher_id){
        return userMapper.deleteUser(teacher_id);
    }
}
