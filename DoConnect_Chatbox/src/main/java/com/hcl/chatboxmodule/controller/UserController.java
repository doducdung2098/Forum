package com.hcl.chatboxmodule.controller;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.helper.ResponseHandler;
import com.hcl.chatboxmodule.model.dto.responseDto.UserDto;
import com.hcl.chatboxmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity proccessRegister(@RequestBody UserDto user){
        UserDto newUser = userService.save(user);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "user", newUser);
    }

    @GetMapping("/chatbox/search")
    public ResponseEntity findByUsername(@RequestParam(name = "keyword") String username){
        UserDto user = userService.findByUsername(username);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "user", user);
    }

    @GetMapping("/users/paged/{paged}")
    public ResponseEntity getAllUser(@PathVariable int paged){
        List<UserDto> userDtos = userService.findAll(paged);
        if (userDtos == null){
            return ResponseHandler.generateResponse(Constant.EMPTY_MESSAGE, HttpStatus.OK, "user", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "users", userDtos);
        }
    }
}
