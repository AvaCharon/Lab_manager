package com.example.lab_manager.service;

import com.example.lab_manager.entity.User;

import java.util.List;

public interface IUserService {

    List<User> listUsers();

    User getUserById(int user_id);

    User getUserByTeacherId(int teacher_id);

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int user_id);
}
