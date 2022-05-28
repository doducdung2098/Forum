package com.hcl.chatboxmodule.controller;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.helper.ResponseHandler;
import com.hcl.chatboxmodule.model.dto.requestDto.UserChatboxInputDto;
import com.hcl.chatboxmodule.model.dto.responseDto.UserChatboxDto;
import com.hcl.chatboxmodule.service.UserChatboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping("/api/v1/user")
public class UserChatboxController {

    private UserChatboxService userChatboxService;

    @Autowired
    public UserChatboxController(UserChatboxService userChatboxService) {
        this.userChatboxService = userChatboxService;
    }

    @GetMapping("/user-chatbox/user-id/{id}")
    public ResponseEntity getUserChatboxByUserId(@PathVariable int id ){
        List<UserChatboxDto> chatboxList = userChatboxService.findAllChatboxByUserId(id);
        if(chatboxList.isEmpty()){
            return ResponseHandler.generateResponse(Constant.EMPTY_MESSAGE, HttpStatus.NO_CONTENT, null, null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "userChatbox", chatboxList);
        }
    }

    @PostMapping("/user-chatbox/check-exist")
    public ResponseEntity getChatboxExistByUserId(@RequestBody UserChatboxInputDto userChatboxInputDto){
        List<UserChatboxDto> userChatbox = userChatboxService.findUserChatboxByUserId(userChatboxInputDto.getUserId1(), userChatboxInputDto.getUserId2());
        if (userChatbox == null){
            return ResponseHandler.generateResponse(Constant.EMPTY_MESSAGE, HttpStatus.OK, "userChatbox", userChatbox);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "userChatbox", userChatbox);
        }
    }

    @PostMapping("/user-chatbox/create-user-chatbox")
    public ResponseEntity createUserChatbox(@RequestBody UserChatboxDto userChatboxDTO){
        UserChatboxDto newUserChatbox = userChatboxService.save(userChatboxDTO);
        if (newUserChatbox == null){
            return ResponseHandler.generateResponse(Constant.EMPTY_MESSAGE, HttpStatus.NOT_FOUND, "userChatbox", null);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "userChatbox", newUserChatbox);
        }
    }
}
