package com.example.lab_manager.dao;

import com.example.lab_manager.entity.Teacher;
import com.example.lab_manager.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> listUsers();

    User getUserById(int user_id);

    User getUserByTeacherId(int teacher_id);

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int user_id);
}
