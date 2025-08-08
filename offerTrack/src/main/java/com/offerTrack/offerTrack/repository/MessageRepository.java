package com.offerTrack.offerTrack.repository;

import com.offerTrack.offerTrack.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Integer> {
}
