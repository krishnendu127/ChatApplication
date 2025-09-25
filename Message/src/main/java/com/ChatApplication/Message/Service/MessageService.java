package com.ChatApplication.Message.Service;

import com.ChatApplication.Message.Config.KafkaProducerConfig;
import com.ChatApplication.Message.Model.MessageModel;
import com.ChatApplication.Message.Repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public void saveMessage(MessageModel messageModel){
        messageRepository.save(messageModel);
        kafkaTemplate.send("message.saved",messageModel.getRoomId(),messageModel);
    }
    public Page<MessageModel> getMessagesByRoomId(String roomId, Pageable pageable){
        return messageRepository.findByRoomIdOrderByDescending(roomId,pageable);
    }
}
