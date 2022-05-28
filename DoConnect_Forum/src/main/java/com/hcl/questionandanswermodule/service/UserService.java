package com.hcl.questionandanswermodule.service;

import com.hcl.questionandanswermodule.model.entity.User;
import com.hcl.questionandanswermodule.model.dto.responseDto.UserDTO;

import java.util.Optional;

public interface UserService extends DAO<UserDTO, User>{
     UserDTO findByUsername(String username);
     Optional<UserDTO> findById(int id);
     boolean sendEmail(String email);

}
