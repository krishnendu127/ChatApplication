package com.ChatApplication.Chat.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "messages")
public class MessageModel {
    @Id
    private String messageId;
    private String roomId;
    private String senderId;
    private String text;
    private Instant timeStamp;
    private String status;
    private boolean edited;
}
