package com.hcl.chatboxmodule.repository;

import com.hcl.chatboxmodule.model.entity.UserChatbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserChatboxRepository extends JpaRepository<UserChatbox, Integer>, JpaSpecificationExecutor<UserChatbox> {
}
