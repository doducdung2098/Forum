package com.hcl.questionandanswermodule.service.impl;

import com.hcl.questionandanswermodule.helper.Constant;
import com.hcl.questionandanswermodule.model.entity.User;
import com.hcl.questionandanswermodule.exception.InvalidInputException;
import com.hcl.questionandanswermodule.repository.UserRepository;
import com.hcl.questionandanswermodule.model.dto.requestDto.DataMailDTO;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;
import com.hcl.questionandanswermodule.service.EmailService;
import com.hcl.questionandanswermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private EmailService mailService;
    private UserRepository userRepository;
    private int minIndex = 0;

    @Autowired
    public UserServiceImpl(EmailService mailService, UserRepository userRepository) {
        this.mailService = mailService;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(UserDTO t) {
        if (t == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        return userRepository.save(t.toEntity()).toDto();
    }

    @Override
    public void deleteById(int id) {
        if (findById(id) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserDTO t) {
        if (t == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (findById(t.getUserId()) == null){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        userRepository.save(t.toEntity());
    }

    @Override
    public List<UserDTO> findAll(int paged) {
        if(paged < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        Pageable pageable = PageRequest.of(paged, 10, Sort.unsorted());
        return toDto(userRepository.findAll(pageable).getContent());
    }

    @Override
    public UserDTO findByUsername(String username) {
        if (username == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findByUsername(username) == null){
            return null;
        }
        else {
            return userRepository.findByUsername(username).toDto();
        }
    }

    @Override
    public Optional<UserDTO> findById(int id) {
        if (id < minIndex){
            throw new InvalidInputException(Constant.INVALID_MESSAGE);
        }
        if (userRepository.findById(id).isPresent()){
           return Optional.ofNullable(userRepository.findById(id).get().toDto());
        }
        else {
            return null;
        }
    }

    @Override
    public boolean sendEmail(String email) {
        if (email == null){
            throw new NullPointerException(Constant.INVALID_MESSAGE);
        }
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(email);
            dataMail.setSubject("To approved question or answers");

            Map<String, Object> props = new HashMap<>();
            props.put("username", email);
            dataMail.setProps(props);

            mailService.sendHtmlMail(dataMail, "client");
            return true;
        }catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    convert to dto
     */

    @Override
    public List<UserDTO> toDto(List<User> users){
        if(users.isEmpty()){
            return new ArrayList<>();
        }else {
            List<UserDTO> userDTOList = new ArrayList<>();
            users.forEach(e -> userDTOList.add(e.toDto()));
            return userDTOList;
        }
    }
}
