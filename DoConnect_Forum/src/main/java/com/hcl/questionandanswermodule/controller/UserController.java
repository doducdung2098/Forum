package com.hcl.questionandanswermodule.controller;

import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.helper.ResponseHandler;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity processRegister(@RequestBody UserDTO user){
        if (user == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        UserDTO userRegister = userService.save(user);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "user", userRegister);
    }

}
