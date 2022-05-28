package com.hcl.authmodule.controller;

import com.hcl.authmodule.helper.ResponseHandler;
import com.hcl.authmodule.model.dto.requestDto.UserLoginDTO;
import com.hcl.authmodule.model.dto.responseDto.UserDto;
import com.hcl.authmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity processLogin(@RequestBody UserLoginDTO user){
        UserDto userLogin = userService.checkLogin(user.getUsername(), user.getPassword());
        if(userLogin != null){
            return ResponseHandler.generateResponse("Successfully!", HttpStatus.OK, "user", userLogin);
        }else {
            return ResponseHandler.generateResponse("fail!", HttpStatus.NOT_FOUND, "user", null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity processRegister(@RequestBody UserDto user){
        UserDto userRegister = userService.save(user);
        if(userRegister == null){
            return ResponseHandler.generateResponse("fail!", HttpStatus.NOT_FOUND, null, null);
        }else {
            return ResponseHandler.generateResponse("Successfully!", HttpStatus.OK, "user", userRegister);
        }
    }
}
