package com.liangwei.demo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.liangwei.demo.mapper.UserMapper;
import com.liangwei.demo.model.User;
import com.liangwei.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByNameAndPassword(String name, String password) {
        List<User> userList = userMapper.getUserByNameAndPassword(name, password);

        Collections.sort(userList,(user1, user2) -> user1.getId() - user2.getId());

        return userList;
    }

    @Override
    public void AddUser(User user) {
        userMapper.AddUser(user);
    }

    @Override
    public void delUserById(int id) {
        userMapper.delUserById(id);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user.getName(),user.getPassword(),user.getId());
    }

    @Override
    public List<User> getUser() {

        List<User> userList = userMapper.getUser();

        // lamdba表达式的使用

        // List<User> userListOrderBy= userList.stream().filter((User u) -> u.getName() == "1212").collect(Collectors.toList());

        Collections.sort(userList,(user1, user2) -> user1.getId() - user2.getId());

        return userList;
    }

}
