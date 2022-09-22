package com.example.mybatisfirst.controller;

import com.example.mybatisfirst.dto.Hobby;
import com.example.mybatisfirst.dto.Nation;
import com.example.mybatisfirst.dto.User;
import com.example.mybatisfirst.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ApiUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        List<User> users= userService.allUsers();
        log.info("users :" +users);

        return users !=null ? ResponseEntity.status(HttpStatus.OK).body(users) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/users/create")
    public ResponseEntity<Integer> createUser(@RequestBody User newUserDto){
        int responseCode=userService.createUser(newUserDto);
        log.info("ResponseCode : "+responseCode);
        return responseCode != 0 ? ResponseEntity.status(HttpStatus.OK).body(responseCode) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/hobby/create")
    public ResponseEntity<Integer> createHobby(@RequestBody List<Hobby> hobbies){
        int responseCode=userService.createHobby(hobbies);
        log.info("ResponseCode : "+responseCode);
        return responseCode !=0 ? ResponseEntity.status(HttpStatus.OK).body(responseCode) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/nation/create")
    public ResponseEntity<Integer> createNation(@RequestBody Nation nation){
        log.info("nation : "+nation);
        int responseCode = 5 ;//userService.createNation(nation);
        log.info("ResponseCode : "+responseCode);

        return responseCode!=0 ? ResponseEntity.status(HttpStatus.OK).body(responseCode) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
