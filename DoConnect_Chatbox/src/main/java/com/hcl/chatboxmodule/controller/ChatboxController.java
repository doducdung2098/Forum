package com.hcl.chatboxmodule.controller;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.helper.ResponseHandler;
import com.hcl.chatboxmodule.model.dto.responseDto.ChatboxDto;
import com.hcl.chatboxmodule.service.ChatboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping("/api/v1/user")
public class ChatboxController {

    private ChatboxService chatboxService;

    @Autowired
    public ChatboxController(ChatboxService chatboxService) {
        this.chatboxService = chatboxService;
    }

    @PostMapping("/create-chatbox")
    public ResponseEntity createChatbox(@RequestBody ChatboxDto chatboxDto){
        ChatboxDto newChatbox = chatboxService.save(chatboxDto);
        if (newChatbox != null){
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "chatbox", newChatbox);
        }else {
            return ResponseHandler.generateResponse(Constant.ERROR_MESSAGE, HttpStatus.NOT_FOUND, null, null);
        }
    }
}
