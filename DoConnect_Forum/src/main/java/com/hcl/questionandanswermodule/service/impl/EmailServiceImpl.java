package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.model.dto.requestDto.DataMailDTO;
import com.hcl.questionandanswermodule.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, SpringTemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        Context context = new Context();
        context.setVariables(dataMail.getProps());

        String html = templateEngine.process(templateName, context);

        helper.setTo(dataMail.getTo());
        helper.setSubject(dataMail.getSubject());
        helper.setText(html, true);

        mailSender.send(message);
    }

    @Override
    public void sendSimpleMessage(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(email);
        message.setSubject("subject");
        message.setText("text");
        mailSender.send(message);
    }
}
