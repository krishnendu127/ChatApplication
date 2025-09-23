package com.ChatApplication.Message.DTO;

import java.time.Instant;

public record MessageRequest(String messageId, String roomId, String senderId, String text, Instant timeStamp, String status, boolean edited) {
}
