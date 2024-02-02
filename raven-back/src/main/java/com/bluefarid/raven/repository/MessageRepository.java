package com.bluefarid.raven.repository;

import com.bluefarid.raven.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
