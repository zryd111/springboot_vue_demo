package com.liangwei.demo.controller;

import com.liangwei.demo.model.User;
import com.liangwei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userLogin")
    public List<User> UserQryByNameAndPassword(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
        System.out.println(userService.getUserByNameAndPassword(name, password).size());
        return userService.getUserByNameAndPassword(name, password);
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    public List<User> UserQry() {
        return userService.getUser();
    }

    @RequestMapping(value ="/user", method = RequestMethod.POST)
    public void UserAdd(User user){
        userService.AddUser(user);
    }

    @RequestMapping(value ="/user", method = RequestMethod.PUT)
    public void UserUpdate(User user){
        userService.updateUserById(user);
    }

    @RequestMapping(value ="/user", method = RequestMethod.DELETE)
    public void UserDel(@RequestParam(value="no") int no){
        userService.delUserById(no);
    }


}
