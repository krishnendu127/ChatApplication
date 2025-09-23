package com.ChatApplication.Message.Controller;

import com.ChatApplication.Message.DTO.MessageRequest;
import com.ChatApplication.Message.Model.MessageModel;
import com.ChatApplication.Message.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/saveMessage")
    public void saveMessage(MessageRequest messageRequest){
        MessageModel messageModel = MessageModel.builder()
                .messageId(messageRequest.messageId())
                .roomId(messageRequest.roomId())
                .edited(messageRequest.edited())
                .senderId(messageRequest.senderId())
                .status(messageRequest.status())
                .text(messageRequest.text())
                .timeStamp(messageRequest.timeStamp())
                .build();
        messageService.saveMessage(messageModel);
    }
    public Page<MessageModel> getMessagesByRoomId(@PathVariable String roomId, @RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(defaultValue = "20") Integer pageSize){
        return messageService.getMessagesByRoomId(roomId, PageRequest.of(pageNumber,pageSize));
    }
}
