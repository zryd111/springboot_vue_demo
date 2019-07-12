package com.liangwei.demo.mapper;

import java.util.List;
import com.liangwei.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name} and password = #{password}")
    List<User> getUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Insert({"insert into user(id, name, password) values(#{id}, #{name}, #{password})"})
    void AddUser(User userInfo);

    @Delete("delete from user where id=#{id}")
    void delUserById(@Param("id") int id);

    @Update("update user set name = #{name}, password = #{password} where id = #{id}")
    void updateUserById(@Param("name") String name, @Param("password") String password, @Param("id") int id);

    @Select("select * from user")
    List<User> getUser();


}
