package com.liangwei.demo.service;

import com.liangwei.demo.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserService {

    List<User> getUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    void AddUser(User user);

    void delUserById(@Param("id") int id);

    void updateUserById(User user);

    List<User> getUser();

}
