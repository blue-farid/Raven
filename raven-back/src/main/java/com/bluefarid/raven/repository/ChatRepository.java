package com.bluefarid.raven.repository;

import com.bluefarid.raven.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
