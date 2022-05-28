package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.dto.requestDto.DataMailDTO;

import javax.mail.MessagingException;

public interface EmailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
    void sendSimpleMessage(String email);
}
