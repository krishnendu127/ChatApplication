package com.ChatApplication.Chat.Client;


import com.ChatApplication.Chat.Model.MessageModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "message-service", url = "http://localhost:8089")
public interface MessageClient {
    @PostMapping("/api/messages/saveMessage")
    MessageModel saveMessage(MessageModel message);
}
