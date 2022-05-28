package com.hcl.chatboxmodule.repository;

import com.hcl.chatboxmodule.model.entity.Chatbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatboxRepository extends JpaRepository<Chatbox, Integer> {
}
