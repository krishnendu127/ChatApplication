package com.ChatApplication.Message.Repository;

import com.ChatApplication.Message.Model.MessageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<MessageModel , String> {
    Page<MessageModel> findByRoomIdOrderByDescending(String roomId, Pageable pageable);
}
