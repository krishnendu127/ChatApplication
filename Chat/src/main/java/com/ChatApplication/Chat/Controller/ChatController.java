package com.ChatApplication.Chat.Controller;

import com.ChatApplication.Chat.Client.MessageClient;
import com.ChatApplication.Chat.Model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessagingTemplate broker;
    private final MessageClient messageClient;

    @MessageMapping("/chat.send")
    public void send(@Payload MessageModel messageModel) {
        messageClient.saveMessage(messageModel);
        broker.convertAndSend("/topic/room." + messageModel.getRoomId(), messageModel);
    }
}
