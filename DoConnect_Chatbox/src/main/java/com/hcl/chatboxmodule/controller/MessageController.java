package com.hcl.chatboxmodule.controller;

import com.hcl.chatboxmodule.helper.Constant;
import com.hcl.chatboxmodule.helper.ResponseHandler;
import com.hcl.chatboxmodule.model.dto.responseDto.MessageDto;
import com.hcl.chatboxmodule.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping("/api/v1/user")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

//    @PostMapping("/chatbox/add-message")
//    public ResponseEntity addMessage(@RequestBody MessageDto message){
//        MessageDto newMessage = messageService.save(message);
//        if(newMessage != null){
//            return ResponseHandler.generateResponse("successfully!", HttpStatus.OK, "message", newMessage);
//        }else {
//            return ResponseHandler.generateResponse("fail!", HttpStatus.NOT_FOUND, null, null);
//        }
//    }

    @GetMapping("/chatbox/{id}/message")
    public ResponseEntity getMessageByChatboxId(@PathVariable int id){
        List<MessageDto> messages = messageService.findMessageByChatboxId(id);
        if(messages.isEmpty()){
            return ResponseHandler.generateResponse(Constant.EMPTY_MESSAGE, HttpStatus.OK, "messages", messages);
        }else {
            return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "messages", messages);
        }
    }


    @MessageMapping("/message")
    @SendTo("/chatbox")
    public ResponseEntity<Object> chat(@RequestBody MessageDto messageDto) throws InterruptedException {
        Thread.sleep(500);
        MessageDto newMessage = messageService.save(messageDto);
        return ResponseHandler.generateResponse(Constant.SUCCESS_MESSAGE, HttpStatus.OK, "message", newMessage);
    }
}
