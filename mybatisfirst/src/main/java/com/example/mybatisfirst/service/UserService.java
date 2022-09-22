package com.example.mybatisfirst.service;

import com.example.mybatisfirst.dao.UserDao;
import com.example.mybatisfirst.dto.Hobby;
import com.example.mybatisfirst.dto.Nation;
import com.example.mybatisfirst.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> allUsers(){
        List<User> users=userDao.allUsers();
        return users;
    }

    public int createUser(User newUserDto){
        int responseCode=userDao.createUser(newUserDto);
        return  responseCode;
    }

    public int createHobby(List<Hobby> hobbies){
        int responseCode=userDao.createHobby(hobbies);
        return responseCode;
    }

    public int createNation(Nation nation){
        int responseCode=userDao.createNation(nation);
        return responseCode;
    }
}
