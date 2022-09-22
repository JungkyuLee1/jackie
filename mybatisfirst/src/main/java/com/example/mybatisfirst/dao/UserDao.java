package com.example.mybatisfirst.dao;

import com.example.mybatisfirst.dto.Hobby;
import com.example.mybatisfirst.dto.Nation;
import com.example.mybatisfirst.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public List<User> allUsers();
    public int createUser(User newUserDto);

    public int createHobby(List<Hobby> hobbies);

    public int createNation(Nation nation);
}
